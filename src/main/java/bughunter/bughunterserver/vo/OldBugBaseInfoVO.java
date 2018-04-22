package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.OldBugBaseInfo;

import java.sql.Date;

public class OldBugBaseInfoVO {

    private int oldId;

    private String bugId;

    private String status;

    private String type;

    private String describe;

    private String current;

    private String priority;

    private UserVO user;

    private Date cTime;

    private Date mTime;

    public OldBugBaseInfoVO(OldBugBaseInfo oldBugBaseInfo) {
        this.oldId = oldBugBaseInfo.getOldId();
        this.bugId = oldBugBaseInfo.getBugId();
        this.status = oldBugBaseInfo.getStatus();
        this.type = oldBugBaseInfo.getType();
        this.current = oldBugBaseInfo.getCurrent();
        this.priority = oldBugBaseInfo.getPriority();
        this.cTime = oldBugBaseInfo.getcTime();
        this.mTime = oldBugBaseInfo.getmTime();
        this.describe = oldBugBaseInfo.getBugDescribe();
        this.user = new UserVO(oldBugBaseInfo.getUser());
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

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
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


    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }
}
