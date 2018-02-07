package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.model.repository.BugRepository;
import bughunter.bughunterserver.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugServiceImpl implements BugService{

    @Autowired
    BugRepository bugRepository;


    @Override
    public Boolean deleteBug(int id) {
        bugRepository.delete(id);
        return null;
    }

    @Override
    public int addBug(BugBaseInfo bugBaseInfo) {
        bugBaseInfo =bugRepository.save(bugBaseInfo);
        return bugBaseInfo.getId();
    }

    @Override
    public Boolean modifyBug(BugBaseInfo bugBaseInfo) {
        bugRepository.save(bugBaseInfo);
        return null;
    }

    @Override
    public BugBaseInfo findBug(int id) {

        return bugRepository.findOne(id);
    }

    @Override
    public List<BugBaseInfo> findAllBugByAppId(int appId) {

        return bugRepository.findAllByAppId(appId);
    }

    @Override
    public List<BugBaseInfo> findAllBugs() {
        return bugRepository.findAll();
    }

    @Override
    public BugConsoleLog findConsoleLogByBugId(int bugId) {
        return null;
    }

    @Override
    public BugDeviceInfo findDeviceInfoByBugId(int bugId) {
        return null;
    }

    @Override
    public BugNetRequest findNetRequestByBugId(int bugId) {
        return null;
    }

    @Override
    public BugOperateStep findOperateStepByBugId(int bugId) {
        return null;
    }

    @Override
    public BugUserData findUserDataByBugId(int bugId) {
        return null;
    }
}
