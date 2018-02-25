package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugUserData;
import org.json.JSONObject;

public class BugUserDataVO {

    private int bugId;

    private String dataString;

    public BugUserDataVO(BugUserData bugUserData) {
        this.bugId = bugUserData.getBugId();
        this.dataString = bugUserData.getDataString();
    }


    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }


    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }
}
