package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class BugBaseInfoVO {

    private int id;

    private String status;

    private String type;

    private int priority;

    private UserVO user;

    private AppBaseInfoVO appBaseInfo;

    private Date cTime;

    private Date mTime;

    public BugBaseInfoVO(BugBaseInfo bugBaseInfo) {
        this.id = bugBaseInfo.getId();
        this.status = bugBaseInfo.getStatus();
        this.type = bugBaseInfo.getType();
        this.priority = bugBaseInfo.getPriority();
        this.cTime = bugBaseInfo.getcTime();
        this.mTime = bugBaseInfo.getmTime();
        this.user = new UserVO(bugBaseInfo.getUser());
        this.appBaseInfo = new AppBaseInfoVO(bugBaseInfo.getAppBaseInfo());
    }

    public BugBaseInfoVO(int id, String status, String type, int priority, UserVO user, AppBaseInfoVO appBaseInfo, Date cTime, Date mTime) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.priority = priority;
        this.user = user;
        this.appBaseInfo = appBaseInfo;
        this.cTime = cTime;
        this.mTime = mTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
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

    public AppBaseInfoVO getAppBaseInfo() {
        return appBaseInfo;
    }

    public void setAppBaseInfo(AppBaseInfoVO appBaseInfo) {
        this.appBaseInfo = appBaseInfo;
    }
}
