package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.model.repository.*;
import bughunter.bughunterserver.service.BugService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;
import org.hibernate.annotations.Synchronize;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    BugDeviceRepository bugDeviceRepository;

    @Autowired
    BugConsoleLogRepository bugConsoleLogRepository;

    @Autowired
    BugOperateStepRepository bugOperateStepRepository;

    @Autowired
    OldBugRepository oldBugRepository;

    @Autowired
    AppVerRepository appVerRepository;


    @Override
    public Boolean deleteBug(BugInfoKeys bugInfoKeys) {
        try {
            //TODO 使用级联删除
            bugRepository.delete(bugInfoKeys);
            bugOperateStepRepository.delete(bugInfoKeys);
            bugConsoleLogRepository.delete(bugInfoKeys);
            bugDeviceRepository.delete(bugInfoKeys);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public BugInfoKeys addBug(BugInfo bugInfo) {
        //TODO 同步问题
        AppVersion appVersion = new AppVersion();
        appVersion.setAppKey(bugInfo.getAppKey());
        appVersion.setAppVersion(bugInfo.getBugBaseInfo().getAppVersion());
        if (!appVerRepository.exists(new AppVersionKeys(appVersion.getAppKey(), appVersion.getAppVersion()))) {
            appVerRepository.save(appVersion);
        }
        String bugId = getBugId();
        bugInfo.setBugId(bugId);
        bugRepository.save(bugInfo.getBugBaseInfo());
        bugDeviceRepository.save(bugInfo.getBugDeviceInfo());
        bugConsoleLogRepository.save(bugInfo.getBugConsoleLog());
        bugOperateStepRepository.save(bugInfo.getBugOperateStep());
        return bugInfo.getBugInfoKeys();
    }

    public static int Guid = 100;

    public static String getBugId() {
        Guid += 1;
        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取时间戳
        String time = dateFormat.format(now);
        String info = now + "";
        //获取三位随机数
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        if (Guid > 999) {
            Guid = 100;
        }
        return time + info.substring(2, info.length()) + Guid;
    }

    @Override
    public Boolean modifyBug(BugInfoKeys bugInfoKeys, JSONObject jsonObject) {
        try {
            BugBaseInfo bugBaseInfo = bugRepository.findOne(bugInfoKeys);
            if (bugBaseInfo == null)
                return false;
            oldBugRepository.save(getOldBugBaseInfo(bugBaseInfo));
            if (jsonObject.has(Constants.TYPE))
                bugBaseInfo.setType(jsonObject.getString(Constants.TYPE));
            if (jsonObject.has(Constants.STATUS))
                bugBaseInfo.setStatus(jsonObject.getString(Constants.STATUS));
            if (jsonObject.has(Constants.DESCRIBE))
                bugBaseInfo.setBugDescribe(jsonObject.getString(Constants.DESCRIBE));
            if (jsonObject.has(Constants.PRIORITY))
                bugBaseInfo.setPriority(jsonObject.getString(Constants.PRIORITY));
            bugBaseInfo.setmTime(Date.valueOf(jsonObject.getString(Constants.MODIFY_TIME)));
            bugBaseInfo.setUserId(jsonObject.getInt(Constants.USER_ID));
            bugRepository.save(bugBaseInfo);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    private OldBugBaseInfo getOldBugBaseInfo(BugBaseInfo bugBaseInfo) {
        OldBugBaseInfo oldBugBaseInfo = new OldBugBaseInfo();
        oldBugBaseInfo.setAppKey(bugBaseInfo.getAppKey());
        oldBugBaseInfo.setBugDescribe(bugBaseInfo.getBugDescribe());
        oldBugBaseInfo.setBugId(bugBaseInfo.getBugId());
        oldBugBaseInfo.setcTime(bugBaseInfo.getcTime());
        oldBugBaseInfo.setCurrent(bugBaseInfo.getCurrent());
        oldBugBaseInfo.setmTime(bugBaseInfo.getmTime());
        oldBugBaseInfo.setPriority(bugBaseInfo.getPriority());
        oldBugBaseInfo.setStatus(bugBaseInfo.getStatus());
        oldBugBaseInfo.setType(bugBaseInfo.getType());
        oldBugBaseInfo.setUserId(bugBaseInfo.getUserId());
        return oldBugBaseInfo;
    }

    @Override
    public BugBaseInfoVO findBugBaseInfo(BugInfoKeys id) {
        if (!bugRepository.exists(id))
            return null;
        BugBaseInfo bugBaseInfo = bugRepository.findOne(id);
        return new BugBaseInfoVO(bugBaseInfo);
    }

    @Override
    public BugInfoVO findWholeBug(BugInfoKeys bugInfoKeys) {
        if (!bugRepository.exists(bugInfoKeys))
            return null;
        BugInfoVO bugInfo = new BugInfoVO();
        bugInfo.setBugBaseInfo(bugRepository.findOne(bugInfoKeys));
        bugInfo.setBugConsoleLog(bugConsoleLogRepository.findOne(bugInfoKeys));
        bugInfo.setBugDeviceInfo(bugDeviceRepository.findOne(bugInfoKeys));
        bugInfo.setBugOperateStep(bugOperateStepRepository.findOne(bugInfoKeys));
        return bugInfo;
    }

    @Override
    public BugConsoleLogVO findConsoleLogByBugId(BugInfoKeys bugInfoKeys) {
        if (!bugRepository.exists(bugInfoKeys))
            return null;
        BugConsoleLog bugConsoleLog = bugConsoleLogRepository.findOne(bugInfoKeys);
        return new BugConsoleLogVO(bugConsoleLog);
    }

    @Override
    public BugDeviceInfoVO findDeviceInfoByBugId(BugInfoKeys bugInfoKeys) {
        if (!bugRepository.exists(bugInfoKeys))
            return null;
        BugDeviceInfo bugDeviceInfo = bugDeviceRepository.findOne(bugInfoKeys);
        return new BugDeviceInfoVO(bugDeviceInfo);
    }

    @Override
    public BugOperateStepVO findOperateStepByBugId(BugInfoKeys bugInfoKeys) {
        if (!bugRepository.exists(bugInfoKeys))
            return null;
        BugOperateStep bugOperateStep = bugOperateStepRepository.findOne(bugInfoKeys);
        return new BugOperateStepVO(bugOperateStep);
    }

    @Override
    public List<BugBaseInfoVO> findAllBugByAppId(String appKey) {
        List<BugBaseInfo> bugBaseInfoList = bugRepository.findAllByAppKey(appKey);
        if (bugBaseInfoList.size() == 0)
            return null;
        List<BugBaseInfoVO> bugBaseInfoVOList = new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo : bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO = new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return bugBaseInfoVOList;
    }

    @Override
    public List<BugBaseInfoVO> findAllBugs() {
        List<BugBaseInfo> bugBaseInfoList = bugRepository.findAll();
        if (bugBaseInfoList.size() == 0)
            return null;
        List<BugBaseInfoVO> bugBaseInfoVOList = new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo : bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO = new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return bugBaseInfoVOList;
    }

    @Override
    public List<BugBaseInfoVO> findSimilarBugs(BugInfoKeys bugInfoKeys) {
        //TODO实现返回相似bug
        if (!bugRepository.exists(bugInfoKeys))
            return null;
        BugBaseInfo bugBaseInfo = bugRepository.findOne(bugInfoKeys);
        return null;
    }

    @Override
    public List<BugInfoVO> findCurrentBugs(String appKey, String current) {
        List<BugBaseInfo> bugBaseInfoList = bugRepository.findAllByAppKeyAndCurrent(appKey, current);
        List<BugInfoVO> bugInfoVOList = new LinkedList<BugInfoVO>();
        for (BugBaseInfo bugBaseInfo : bugBaseInfoList) {
            BugInfoKeys bugInfoKeys = new BugInfoKeys(bugBaseInfo.getAppKey(), bugBaseInfo.getBugId());
            BugInfoVO bugInfo = new BugInfoVO();
            bugInfo.setBugBaseInfo(bugRepository.findOne(bugInfoKeys));
            bugInfo.setBugConsoleLog(bugConsoleLogRepository.findOne(bugInfoKeys));
            bugInfo.setBugDeviceInfo(bugDeviceRepository.findOne(bugInfoKeys));
            bugInfo.setBugOperateStep(bugOperateStepRepository.findOne(bugInfoKeys));
            bugInfoVOList.add(bugInfo);
        }
        return bugInfoVOList;
    }

    @Override
    public List<OldBugBaseInfoVO> findOldBug(String appKey, String bugId) {
        List<OldBugBaseInfo> oldBugBaseInfoList = oldBugRepository.findAllByAppKeyAndBugId(appKey, bugId);
        if (oldBugBaseInfoList.size() == 0)
            return null;
        List<OldBugBaseInfoVO> oldBugBaseInfoVOList = new LinkedList<OldBugBaseInfoVO>();
        for (OldBugBaseInfo oldBugBaseInfo : oldBugBaseInfoList) {
            OldBugBaseInfoVO oldBugBaseInfoVO = new OldBugBaseInfoVO(oldBugBaseInfo);
            oldBugBaseInfoVOList.add(oldBugBaseInfoVO);
        }
        return oldBugBaseInfoVOList;
    }

}
