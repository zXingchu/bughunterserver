package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;

import java.util.List;

public interface BugService {

    Boolean deleteBug(int id);

    int addBug(BugInfo bugInfo);

    Boolean modifyBug(int bugId, JSONObject jsonObject);

    BugBaseInfoVO findBugBaseInfo(int id);

    BugInfoVO findWholeBug(int bugId);

    List<BugBaseInfoVO> findAllBugByAppId(int appId);

    List<BugBaseInfoVO> findAllBugs();

    List<BugBaseInfoVO> findSimilarBugs(int bugId);

    BugConsoleLogVO findConsoleLogByBugId(int bugId);

    BugDeviceInfoVO findDeviceInfoByBugId(int bugId);

    BugNetRequestVO findNetRequestByBugId(int bugId);

    BugOperateStepVO findOperateStepByBugId(int bugId);

    BugUserDataVO findUserDataByBugId(int bugId);

}
