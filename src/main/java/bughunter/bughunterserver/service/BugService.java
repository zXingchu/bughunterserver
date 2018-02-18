package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.*;

import java.util.List;

public interface BugService {

    Boolean deleteBug(int id);

    int addBug(BugBaseInfo bugBaseInfo);

    Boolean modifyBug(BugBaseInfo bugBaseInfo);

    BugBaseInfo findBug(int id);

    List<BugBaseInfo> findAllBugByAppId(int appId);

    List<BugBaseInfo> findAllBugs();

    List<BugBaseInfo> findSimilarBugs(BugBaseInfo bugBaseInfo);

    BugConsoleLog findConsoleLogByBugId(int bugId);

    BugDeviceInfo findDeviceInfoByBugId(int bugId);

    BugNetRequest findNetRequestByBugId(int bugId);

    BugOperateStep findOperateStepByBugId(int bugId);

    BugUserData findUserDataByBugId(int bugId);

}
