package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.*;

import java.util.List;

public interface BugService {

    Boolean deleteBug(int id);

    int addBug(BugInfo bugInfo);

    Boolean modifyBug(BugInfo bugInfo);

    BugInfo findBug(int id);

    List<BugInfo> findAllBugByAppId(int appId);

    List<AppBaseInfo> findAllBugs();

    BugConsoleLog findConsoleLogByBugId(int bugId);

    BugDeviceInfo findDeviceInfoByBugId(int bugId);

    BugNetRequest findNetRequestByBugId(int bugId);

    BugOperateStep findOperateStepByBugId(int bugId);

    BugUserData findUserDataByBugId(int bugId);

}
