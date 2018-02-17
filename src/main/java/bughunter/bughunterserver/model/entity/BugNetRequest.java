package bughunter.bughunterserver.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bug_net_request")
public class BugNetRequest {

    private int bugId;

    private String netRequest;

    public String getNetRequest() {
        return netRequest;
    }

    public void setNetRequest(String netRequest) {
        this.netRequest = netRequest;
    }

    @Id
    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }
}
