package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugUserData;
import org.json.JSONObject;

public class BugUserDataVO {

    private int bugId;

    private JSONObject dataString;

    public BugUserDataVO(BugUserData bugUserData) {
        this.bugId = bugUserData.getBugId();
        this.dataString = bugUserData.getDataString();
    }

    public BugUserDataVO(int bugId, JSONObject dataString) {
        this.bugId = bugId;
        this.dataString = dataString;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }


    public JSONObject getDataString() {
        return dataString;
    }

    public void setDataString(JSONObject dataString) {
        this.dataString = dataString;
    }
}
