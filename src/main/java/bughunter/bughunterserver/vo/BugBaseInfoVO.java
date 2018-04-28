package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

public class BugBaseInfoVO {

    private String bugId;

    private String appVersion;

    private String status;

    private String type;

    private String describe;

    private String current;

    private String priority;

    private UserVO user;

    private Timestamp cTime;

    private Timestamp mTime;

    public BugBaseInfoVO(BugBaseInfo bugBaseInfo) {
        this.bugId = bugBaseInfo.getBugId();
        this.appVersion = bugBaseInfo.getAppVersion();
        this.status = bugBaseInfo.getStatus();
        this.type = bugBaseInfo.getType();
        this.current = bugBaseInfo.getCurrent();
        this.priority = bugBaseInfo.getPriority();
        this.cTime = bugBaseInfo.getcTime();
        this.mTime = bugBaseInfo.getmTime();
        this.describe = bugBaseInfo.getBugDescribe();
        this.user = new UserVO(bugBaseInfo.getUser());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Timestamp getcTime() {
        return cTime;
    }

    public void setcTime(Timestamp cTime) {
        this.cTime = cTime;
    }

    public Timestamp getmTime() {
        return mTime;
    }

    public void setmTime(Timestamp mTime) {
        this.mTime = mTime;
    }
}
