package bughunter.bughunterserver.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bug_console_log")
public class BugConsoleLog {

    private int bugId;

    private String logString;

    @Id
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
