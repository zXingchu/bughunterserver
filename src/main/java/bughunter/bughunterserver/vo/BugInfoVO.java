package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.*;

public class BugInfoVO {

    private BugBaseInfoVO bugBaseInfo;

    private BugUserDataVO bugUserData;

    private BugOperateStepVO bugOperateStep;

    private BugNetRequestVO bugNetRequest;

    private BugDeviceInfoVO bugDeviceInfo;

    private BugConsoleLogVO bugConsoleLog;



    public BugBaseInfoVO getBugBaseInfo() {
        return bugBaseInfo;
    }

    public void setBugBaseInfo(BugBaseInfo bugBaseInfo) {
        this.bugBaseInfo = new BugBaseInfoVO(bugBaseInfo);
    }

    public BugUserDataVO getBugUserData() {
        return bugUserData;
    }

    public void setBugUserData(BugUserData bugUserData) {
        this.bugUserData = new BugUserDataVO(bugUserData);
    }

    public BugOperateStepVO getBugOperateStep() {
        return bugOperateStep;
    }

    public void setBugOperateStep(BugOperateStep bugOperateStep) {
        this.bugOperateStep = new BugOperateStepVO(bugOperateStep);
    }

    public BugNetRequestVO getBugNetRequest() {
        return bugNetRequest;
    }

    public void setBugNetRequest(BugNetRequest bugNetRequest) {
        this.bugNetRequest = new BugNetRequestVO(bugNetRequest);
    }

    public BugDeviceInfoVO getBugDeviceInfo() {
        return bugDeviceInfo;
    }

    public void setBugDeviceInfo(BugDeviceInfo bugDeviceInfo) {
        this.bugDeviceInfo = new BugDeviceInfoVO(bugDeviceInfo);
    }

    public BugConsoleLogVO getBugConsoleLog() {
        return bugConsoleLog;
    }

    public void setBugConsoleLog(BugConsoleLog bugConsoleLog) {
        this.bugConsoleLog = new BugConsoleLogVO(bugConsoleLog);
    }
}
