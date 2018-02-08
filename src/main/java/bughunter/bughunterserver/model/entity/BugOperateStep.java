package bughunter.bughunterserver.model.entity;

public class BugOperateStep {

    private int bugId;

    private String operateStep;


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
