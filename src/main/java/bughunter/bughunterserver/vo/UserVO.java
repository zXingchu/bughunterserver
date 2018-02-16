package bughunter.bughunterserver.vo;

import bughunter.bughunterserver.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class UserVO {

    private int id;

    private String name;

    private String pwd;

    private String email;

    private String teleNumber;

    public UserVO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.pwd = user.getPwd();
        this.email = user.getEmail();
        this.teleNumber = user.getTeleNumber();
    }

    public UserVO(int id, String name, String pwd, String email, String teleNumber) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.teleNumber = teleNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeleNumber() {
        return teleNumber;
    }

    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }
}