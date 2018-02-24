package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.model.repository.*;
import bughunter.bughunterserver.service.BugService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BugServiceImpl implements BugService{

    @Autowired
    BugRepository bugRepository;

    @Autowired
    BugDeviceRepository bugDeviceRepository;

    @Autowired
    BugConsoleLogRepository bugConsoleLogRepository;

    @Autowired
    BugOperateStepRepository bugOperateStepRepository;

    @Autowired
    BugUserDataRepository bugUserDataRepository;

    @Autowired
    BugNetRequestRepository bugNetRequestRepository;


    @Override
    public Boolean deleteBug(int id) {
        try {
            bugRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public int addBug(BugInfo bugInfo) {
        bugInfo.setBugId(bugRepository.save(bugInfo.getBugBaseInfo()).getId());
        bugUserDataRepository.save(bugInfo.getBugUserData());
        bugNetRequestRepository.save(bugInfo.getBugNetRequest());
        bugDeviceRepository.save(bugInfo.getBugDeviceInfo());
        bugConsoleLogRepository.save(bugInfo.getBugConsoleLog());
        bugOperateStepRepository.save(bugInfo.getBugOperateStep());
        return bugInfo.getBugId();
    }

    @Override
    public Boolean modifyBug(int bugId, JSONObject jsonObject) {
        try {
            BugBaseInfo bugBaseInfo=bugRepository.findOne(bugId);
            if(bugBaseInfo==null)
                return false;
            bugBaseInfo.setType(jsonObject.getString(Constants.TYPE));
            bugBaseInfo.setStatus(jsonObject.getString(Constants.STATUS));
            bugBaseInfo.setmTime(Date.valueOf(jsonObject.getString(Constants.MODIFY_TIME)));
            bugRepository.save(bugBaseInfo);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public BugBaseInfoVO findBugBaseInfo(int id) {
        if(!bugRepository.exists(id))
            return null;
        BugBaseInfo bugBaseInfo = bugRepository.findOne(id);
        return new BugBaseInfoVO(bugBaseInfo);
    }

    @Override
    public BugInfoVO findWholeBug(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugInfoVO bugInfo=new BugInfoVO();
        bugInfo.setBugBaseInfo(bugRepository.findOne(bugId));
        bugInfo.setBugConsoleLog(bugConsoleLogRepository.findOne(bugId));
        bugInfo.setBugDeviceInfo(bugDeviceRepository.findOne(bugId));
        bugInfo.setBugNetRequest(bugNetRequestRepository.findOne(bugId));
        bugInfo.setBugOperateStep(bugOperateStepRepository.findOne(bugId));
        bugInfo.setBugUserData(bugUserDataRepository.findOne(bugId));
        return bugInfo;
    }

    @Override
    public List<BugBaseInfoVO> findAllBugByAppId(int appId) {
        List<BugBaseInfo> bugBaseInfoList = bugRepository.findAllByAppId(appId);
        if(bugBaseInfoList==null)
            return null;
        List<BugBaseInfoVO> bugBaseInfoVOList=new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo:bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO=new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return bugBaseInfoVOList;
    }

    @Override
    public List<BugBaseInfoVO> findAllBugs() {
        List<BugBaseInfo> bugBaseInfoList =  bugRepository.findAll();
        if(bugBaseInfoList==null)
            return null;
        List<BugBaseInfoVO> bugBaseInfoVOList=new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo:bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO=new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return bugBaseInfoVOList;
    }

    @Override
    public List<BugBaseInfoVO> findSimilarBugs(int bugId) {
        //TODO
        if(!bugRepository.exists(bugId))
            return null;
        return null;
    }

    @Override
    public BugConsoleLogVO findConsoleLogByBugId(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugConsoleLog bugConsoleLog = bugConsoleLogRepository.findOne(bugId);
        return new BugConsoleLogVO(bugConsoleLog);
    }

    @Override
    public BugDeviceInfoVO findDeviceInfoByBugId(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugDeviceInfo bugDeviceInfo = bugDeviceRepository.findOne(bugId);
        return new BugDeviceInfoVO(bugDeviceInfo);
    }

    @Override
    public BugNetRequestVO findNetRequestByBugId(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugNetRequest bugNetRequest = bugNetRequestRepository.findOne(bugId);
        return new BugNetRequestVO(bugNetRequest);
    }

    @Override
    public BugOperateStepVO findOperateStepByBugId(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugOperateStep bugOperateStep = bugOperateStepRepository.findOne(bugId);
        return new BugOperateStepVO(bugOperateStep);
    }

    @Override
    public BugUserDataVO findUserDataByBugId(int bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugUserData bugUserData = bugUserDataRepository.findOne(bugId);
        return new BugUserDataVO(bugUserData);
    }
}
