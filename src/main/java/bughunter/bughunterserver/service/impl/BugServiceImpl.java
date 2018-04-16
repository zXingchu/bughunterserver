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


    @Override
    public Boolean deleteBug(BugInfoKeys bugInfoKeys) {
        try {
            //TODO 使用级联删除
            bugRepository.delete(bugInfoKeys);
            bugOperateStepRepository.delete(bugInfoKeys);
            bugConsoleLogRepository.delete(bugInfoKeys);
            bugDeviceRepository.delete(bugInfoKeys);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public int addBug(BugInfo bugInfo) {
        //TODO 联合主键很有问题
        bugInfo.setBugId(bugRepository.save(bugInfo.getBugBaseInfo()).getBugId());
        bugDeviceRepository.save(bugInfo.getBugDeviceInfo());
        bugConsoleLogRepository.save(bugInfo.getBugConsoleLog());
        bugOperateStepRepository.save(bugInfo.getBugOperateStep());
        return bugInfo.getBugId();
    }

    @Override
    public Boolean modifyBug(BugInfoKeys bugInfoKeys, JSONObject jsonObject) {
        //TODO 更多的修改
        try {
            BugBaseInfo bugBaseInfo=bugRepository.findOne(bugInfoKeys);
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
    public BugBaseInfoVO findBugBaseInfo(BugInfoKeys id) {
        if(!bugRepository.exists(id))
            return null;
        BugBaseInfo bugBaseInfo = bugRepository.findOne(id);
        return new BugBaseInfoVO(bugBaseInfo);
    }

    @Override
    public BugInfoVO findWholeBug(BugInfoKeys bugId) {
        if(!bugRepository.exists(bugId))
            return null;
        BugInfoVO bugInfo=new BugInfoVO();
        bugInfo.setBugBaseInfo(bugRepository.findOne(bugId));
        bugInfo.setBugConsoleLog(bugConsoleLogRepository.findOne(bugId));
        bugInfo.setBugDeviceInfo(bugDeviceRepository.findOne(bugId));
        bugInfo.setBugOperateStep(bugOperateStepRepository.findOne(bugId));
        return bugInfo;
    }

    @Override
    public BugConsoleLogVO findConsoleLogByBugId(BugInfoKeys bugInfoKeys) {
        if(!bugRepository.exists(bugInfoKeys))
            return null;
        BugConsoleLog bugConsoleLog = bugConsoleLogRepository.findOne(bugInfoKeys);
        return new BugConsoleLogVO(bugConsoleLog);
    }

    @Override
    public BugDeviceInfoVO findDeviceInfoByBugId(BugInfoKeys bugInfoKeys) {
        if(!bugRepository.exists(bugInfoKeys))
            return null;
        BugDeviceInfo bugDeviceInfo = bugDeviceRepository.findOne(bugInfoKeys);
        return new BugDeviceInfoVO(bugDeviceInfo);
    }

    @Override
    public BugOperateStepVO findOperateStepByBugId(BugInfoKeys bugInfoKeys) {
        if(!bugRepository.exists(bugInfoKeys))
            return null;
        BugOperateStep bugOperateStep = bugOperateStepRepository.findOne(bugInfoKeys);
        return new BugOperateStepVO(bugOperateStep);
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
    public List<BugBaseInfoVO> findSimilarBugs(BugInfoKeys bugInfoKeys) {
        //TODO 实现返回相似bug
        if(!bugRepository.exists(bugInfoKeys))
            return null;
        BugBaseInfo bugBaseInfo=bugRepository.findOne(bugInfoKeys);
        return null;
    }

    @Override
    public List<BugBaseInfoVO> findCurrentBugs(String current) {
        //TODO 实现返回当前界面Bug
        return null;
    }

}
