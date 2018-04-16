package bughunter.bughunterserver.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "app_bug_info")
@IdClass(BugInfoKeys.class)
public class BugBaseInfo {

    private int bugId;

    private int appId;

    private AppBaseInfo appBaseInfo;

    private String status;

    private String type;

    private String describe;

    private int priority;

    private int uId;

    private User user;

    private Date cTime;

    private Date mTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }


    @Id
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
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

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appId", insertable=false, updatable=false)
    public AppBaseInfo getAppBaseInfo() {
        return appBaseInfo;
    }

    public void setAppBaseInfo(AppBaseInfo appBaseInfo) {
        this.appBaseInfo = appBaseInfo;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uId", insertable=false, updatable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


}
