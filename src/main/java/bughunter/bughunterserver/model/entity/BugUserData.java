package bughunter.bughunterserver.model.entity;

import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bug_user_data")
public class BugUserData {

    private int bugId;

    private JSONObject dataString;

    @Id
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
