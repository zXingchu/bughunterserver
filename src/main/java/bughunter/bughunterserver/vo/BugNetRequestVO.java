package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugNetRequest;

public class BugNetRequestVO {

    private int bugId;

    private String netRequest;

    public BugNetRequestVO(BugNetRequest bugNetRequest) {
        this.bugId = bugNetRequest.getBugId();
        this.netRequest = bugNetRequest.getNetRequest();
    }

    public BugNetRequestVO(int bugId, String netRequest) {
        this.bugId = bugId;
        this.netRequest = netRequest;
    }

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
