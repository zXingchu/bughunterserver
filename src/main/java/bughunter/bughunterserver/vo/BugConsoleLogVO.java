package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugConsoleLog;

public class BugConsoleLogVO {

    private int bugId;

    private String logString;


    public BugConsoleLogVO(BugConsoleLog bugConsoleLog) {
        this.bugId = bugConsoleLog.getBugId();
        this.logString = bugConsoleLog.getLogString();
    }

    public BugConsoleLogVO(int bugId, String logString) {
        this.bugId = bugId;
        this.logString = logString;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getLogString() {
        return logString;
    }

    public void setLogString(String logString) {
        this.logString = logString;
    }
}
