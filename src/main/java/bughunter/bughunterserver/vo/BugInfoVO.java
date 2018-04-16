package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.*;

public class BugInfoVO {

    private BugBaseInfoVO bugBaseInfo;

    private BugOperateStepVO bugOperateStep;

    private BugDeviceInfoVO bugDeviceInfo;

    private BugConsoleLogVO bugConsoleLog;



    public BugBaseInfoVO getBugBaseInfo() {
        return bugBaseInfo;
    }

    public void setBugBaseInfo(BugBaseInfo bugBaseInfo) {
        this.bugBaseInfo = new BugBaseInfoVO(bugBaseInfo);
    }


    public BugOperateStepVO getBugOperateStep() {
        return bugOperateStep;
    }

    public void setBugOperateStep(BugOperateStep bugOperateStep) {
        this.bugOperateStep = new BugOperateStepVO(bugOperateStep);
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
