package bughunter.bughunterserver.model.entity;


import javax.persistence.Entity;

@Entity(name = "bug_device_info")
public class BugDeviceInfo {

    private int id;

    //制造商
    private String manufacturer;

    //设备型号
    private String deviceModel;

    //运营商
    private String operator;

    //分辨率
    private String resolution;

    //TODO 用电量（百分数表示为好）
    private String electricity;

    //TODO 截图，图片转string存放
    private String screenshot;

    private int bugId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }
}
