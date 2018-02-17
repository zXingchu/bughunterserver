package bughunter.bughunterserver.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bug_operate_step")
public class BugOperateStep {

    private int bugId;

    private String operateStep;

    @Id
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
