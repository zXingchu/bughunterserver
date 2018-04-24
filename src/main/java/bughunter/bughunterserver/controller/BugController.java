package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.model.entity.BugInfo;
import bughunter.bughunterserver.model.entity.BugInfoKeys;
import bughunter.bughunterserver.model.entity.OldBugBaseInfo;
import bughunter.bughunterserver.service.BugService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/app/bug")
public class BugController {

    @Autowired
    BugService bugService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public BugController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @RequestMapping(value = "/{appKey}/{bugId}/getSimilarity", method = RequestMethod.POST)
//    public @ResponseBody
//    ResultMessage getSimilarBug(HttpServletRequest request, @PathVariable int appKey, @PathVariable int bugId, @RequestBody String jsonStr) {
//        List<BugBaseInfoVO> bugBaseInfoList = bugService.findSimilarBugs(getBugInfoKeys(appKey, bugId));
//        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
//    }

    @RequestMapping(value = "/{appKey}/{current}/getCurrentActivityBug", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getCurrentActivityBug(HttpServletRequest request, @PathVariable String appKey, @PathVariable String current) {
        List<BugInfoVO> bugBaseInfoList = bugService.findCurrentBugs(appKey, current);
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }


    @RequestMapping(value = "/{appKey}/getAll", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getAllBugByAppKey(HttpServletRequest request, @PathVariable String appKey) {
        List<BugBaseInfoVO> bugBaseInfoList = bugService.findAllBugByAppId(appKey);
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }

    @RequestMapping(value = "/{appKey}/{appVersion}/getAllByAppVersion", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getAllByAppVersion(HttpServletRequest request, @PathVariable String appKey, @PathVariable String appVersion) {
        List<BugBaseInfoVO> bugBaseInfoList = bugService.findAllBugByAppKeyAndVersion(appKey,appVersion);
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage submitBug(@RequestParam(name = "bug") String jsonStr, @RequestParam(name = "screenshot", required = false) MultipartFile file) {
        String screenshotName = Constants.SCREENSHOT_NO_EXIST;
        if (file != null && !file.isEmpty()) {
            try {
                File logoSaveFile = new File(Constants.SCREENSHOT_BASE_URL);
                if (!logoSaveFile.exists()) {
                    logoSaveFile.mkdirs();
                }
                screenshotName = file.getOriginalFilename();
                String suffix = file.getOriginalFilename().substring
                        (file.getOriginalFilename().lastIndexOf("."));
                String screenshotFileName = Constants.SCREENSHOT_BASE_URL + File.separator + screenshotName;
                File screenshotFile = new File(screenshotFileName);
                file.transferTo(screenshotFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new ResultMessage(1, e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultMessage(1, e.getMessage());
            }
        }
        JSONObject jsonObject = new JSONObject(jsonStr);
        BugInfo bugInfo = new BugInfo(jsonObject, screenshotName);
        BugInfoKeys bugInfoKey = bugService.addBug(bugInfo);
        return ResultMessageFactory.getResultMessage(bugInfoKey);
    }


    @RequestMapping(value = "/{appKey}/{bugId}/get", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugById(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        BugInfoVO bugInfo = bugService.findWholeBug(getBugInfoKeys(appKey, bugId));
        return ResultMessageFactory.getResultMessage(bugInfo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/screenshot/{filename:.+}")
    public @ResponseBody
    ResponseEntity<?> getScreenshot(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(Constants.SCREENSHOT_BASE_URL, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{appKey}/getAfterScreen", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getAllBugByScreen(HttpServletRequest request, @PathVariable String appKey, @RequestParam(name = "screenCondition") String jsonStr) {
        List<BugBaseInfoVO> bugBaseInfoList = bugService.findAllBugByScreen(appKey, new JSONObject(jsonStr));
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/oldGet", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getOldBugById(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        List<OldBugBaseInfoVO> oldBugBaseInfoVOList = bugService.findOldBug(appKey, bugId);
        return ResultMessageFactory.getResultMessage(oldBugBaseInfoVOList);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage modifyBug(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId, @RequestBody String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        return ResultMessageFactory.getResultMessage(bugService.modifyBug(getBugInfoKeys(appKey, bugId), jsonObject), Constants.ERROR);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage deleteBug(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId, @RequestBody String jsonStr) {
        return ResultMessageFactory.getResultMessage(bugService.deleteBug(getBugInfoKeys(appKey, bugId)), Constants.ERROR_NO_EXIST);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/base", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugBaseInfo(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        BugBaseInfoVO bugBaseInfo = bugService.findBugBaseInfo(getBugInfoKeys(appKey, bugId));
        return ResultMessageFactory.getResultMessage(bugBaseInfo);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/device", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugDeviceInfo(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        BugDeviceInfoVO bugDeviceInfo = bugService.findDeviceInfoByBugId(getBugInfoKeys(appKey, bugId));
        return ResultMessageFactory.getResultMessage(bugDeviceInfo);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/console", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugConsoleLog(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        BugConsoleLogVO bugConsoleLog = bugService.findConsoleLogByBugId(getBugInfoKeys(appKey, bugId));
        return ResultMessageFactory.getResultMessage(bugConsoleLog);
    }

    @RequestMapping(value = "/{appKey}/{bugId}/step", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugOperateStep(HttpServletRequest request, @PathVariable String appKey, @PathVariable String bugId) {
        BugOperateStepVO bugOperateStep = bugService.findOperateStepByBugId(getBugInfoKeys(appKey, bugId));
        return ResultMessageFactory.getResultMessage(bugOperateStep);
    }


    private static BugInfoKeys getBugInfoKeys(String appKey, String bugId) {
        return new BugInfoKeys(appKey, bugId);
    }

}
