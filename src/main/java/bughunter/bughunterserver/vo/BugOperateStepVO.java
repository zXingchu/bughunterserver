package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugOperateStep;

public class BugOperateStepVO {

    private int bugId;

    private String operateStep;

    public BugOperateStepVO(BugOperateStep bugOperateStep) {
        this.bugId=bugOperateStep.getBugId();
        this.operateStep=bugOperateStep.getOperateStep();
    }

    public BugOperateStepVO(int bugId, String operateStep) {
        this.bugId = bugId;
        this.operateStep = operateStep;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getOperateStep() {
        return operateStep;
    }

    public void setOperateStep(String operateStep) {
        this.operateStep = operateStep;
    }
}
