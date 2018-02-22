package bughunter.bughunterserver.vo;


import bughunter.bughunterserver.model.entity.AppMember;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AppMemberVO {

    private int id;

    private int appId;

    private int uId;

    public AppMemberVO(AppMember appMember) {
        this.appId=appMember.getAppId();
        this.uId=appMember.getuId();
        this.id=appMember.getId();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
}
