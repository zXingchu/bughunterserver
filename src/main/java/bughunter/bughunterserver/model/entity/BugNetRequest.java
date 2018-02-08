package bughunter.bughunterserver.model.entity;

public class BugNetRequest {

    private int bugId;

    private String netRequest;


    public String getNetRequest() {
        return netRequest;
    }

    public void setNetRequest(String netRequest) {
        this.netRequest = netRequest;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }
}
