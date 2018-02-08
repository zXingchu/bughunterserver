package bughunter.bughunterserver.model.entity;

public class BugConsoleLog {

    private int bugId;

    private String logString;

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
