package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;

import java.util.List;

public interface BugService {

    Boolean deleteBug(BugInfoKeys bugInfoKeys);

    int addBug(BugInfo bugInfo);

    Boolean modifyBug(BugInfoKeys bugInfoKeys, JSONObject jsonObject);

    BugBaseInfoVO findBugBaseInfo(BugInfoKeys bugInfoKeys);

    BugInfoVO findWholeBug(BugInfoKeys bugInfoKeys);

    BugConsoleLogVO findConsoleLogByBugId(BugInfoKeys bugInfoKeys);

    BugDeviceInfoVO findDeviceInfoByBugId(BugInfoKeys bugInfoKeys);

    BugOperateStepVO findOperateStepByBugId(BugInfoKeys bugInfoKeys);

    List<BugBaseInfoVO> findSimilarBugs(BugInfoKeys bugInfoKeys);

    List<BugBaseInfoVO> findAllBugByAppId(int appId);

    List<BugBaseInfoVO> findAllBugs();

    public List<BugBaseInfoVO> findCurrentBugs(String current);

}
