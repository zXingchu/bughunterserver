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
        return null;
    }

    @Override
    public int addBug(BugInfo bugInfo) {
        return 0;
    }

    @Override
    public Boolean modifyBug(BugInfo bugInfo) {
        return null;
    }

    @Override
    public BugInfo findBug(int id) {
        return null;
    }

    @Override
    public List<BugInfo> findAllBugByAppId(int appId) {
        return null;
    }

    @Override
    public List<AppBaseInfo> findAllBugs() {
        return null;
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
