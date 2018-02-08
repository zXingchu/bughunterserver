package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.model.repository.*;
import bughunter.bughunterserver.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return bugConsoleLogRepository.findOne(bugId);
    }

    @Override
    public BugDeviceInfo findDeviceInfoByBugId(int bugId) {

        return bugDeviceRepository.findOne(bugId);
    }

    @Override
    public BugNetRequest findNetRequestByBugId(int bugId) {

        return bugNetRequestRepository.findOne(bugId);
    }

    @Override
    public BugOperateStep findOperateStepByBugId(int bugId) {

        return bugOperateStepRepository.findOne(bugId);
    }

    @Override
    public BugUserData findUserDataByBugId(int bugId) {

        return bugUserDataRepository.findOne(bugId);
    }
}
