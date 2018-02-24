package bughunter.bughunterserver.model.entity;

import bughunter.bughunterserver.until.Constants;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import java.sql.Date;

public class BugInfo {

    private Integer bugId;

    private BugBaseInfo bugBaseInfo;

    private BugConsoleLog bugConsoleLog;

    private BugDeviceInfo bugDeviceInfo;

    private BugNetRequest bugNetRequest;

    private BugOperateStep bugOperateStep;

    private BugUserData bugUserData;

    public BugInfo(JSONObject jsonObject){
        JSONObject bugBaseInfoJSON=jsonObject.getJSONObject(Constants.BUG_BASE_INFO);
        bugBaseInfo.setAppId(Integer.parseInt(bugBaseInfoJSON.getString(Constants.APP_ID)));
        bugBaseInfo.setPriority(Integer.parseInt(bugBaseInfoJSON.getString(Constants.PRIORITY)));
        bugBaseInfo.setStatus(bugBaseInfoJSON.getString(Constants.STATUS));
        bugBaseInfo.setType(bugBaseInfoJSON.getString(Constants.TYPE));
        bugBaseInfo.setcTime(new Date(new java.util.Date().getTime()));
        bugBaseInfo.setmTime(bugBaseInfo.getcTime());
        bugBaseInfo.setuId(Integer.parseInt(bugBaseInfoJSON.getString(Constants.USER_ID)));
//        int id=bugService.addBug(bugBaseInfo);
        JSONObject bugConsoleLogJSON=jsonObject.getJSONObject(Constants.BUG_CONSOLE_LOG);
        JSONObject bugDeviceInfoJSON=jsonObject.getJSONObject(Constants.BUG_DEVICE_INFO);
        JSONObject bugNetRequestJSON=jsonObject.getJSONObject(Constants.BUG_NET_REQUEST);
        JSONObject bugOperateStepJSON=jsonObject.getJSONObject(Constants.BUG_OPERATE_STEP);
        JSONObject bugUserDataJSON=jsonObject.getJSONObject(Constants.BUG_USER_DATA);
        this.bugConsoleLog.setLogString(bugConsoleLogJSON.getString(Constants.LOG_STRING));
        this.bugNetRequest.setNetRequest(bugNetRequestJSON.getString(Constants.NET_REQUEST));
        this.bugOperateStep.setOperateStep(bugOperateStepJSON.getString(Constants.OPERATE_STEP));
        this.bugUserData.setDataString(bugUserDataJSON.getString(Constants.DATA_STRING));

        this.bugDeviceInfo.setDeviceModel(bugDeviceInfoJSON.getString(Constants.DEVICEMODEL));
        this.bugDeviceInfo.setElectricity(bugDeviceInfoJSON.getString(Constants.ELECTRICITY));
        this.bugDeviceInfo.setManufacturer(bugDeviceInfoJSON.getString(Constants.MANUFACTURER));
        this.bugDeviceInfo.setOperator(bugDeviceInfoJSON.getString(Constants.OPERATOR));
        this.bugDeviceInfo.setResolution(bugDeviceInfoJSON.getString(Constants.RESOLUTION));
        this.bugDeviceInfo.setScreenshot(bugDeviceInfoJSON.getString(Constants.SCREENSHOT));

    }

    public BugBaseInfo getBugBaseInfo() {
        return bugBaseInfo;
    }

    public BugConsoleLog getBugConsoleLog() {
        return bugConsoleLog;
    }

    public BugDeviceInfo getBugDeviceInfo() {
        return bugDeviceInfo;
    }

    public BugNetRequest getBugNetRequest() {
        return bugNetRequest;
    }


    public BugOperateStep getBugOperateStep() {
        return bugOperateStep;
    }


    public BugUserData getBugUserData() {
        return bugUserData;
    }

    public void setBugId(int bugId) {
        this.bugConsoleLog.setBugId(bugId);
        this.bugDeviceInfo.setBugId(bugId);
        this.bugNetRequest.setBugId(bugId);
        this.bugOperateStep.setBugId(bugId);
        this.bugUserData.setBugId(bugId);
    }

    public Integer getBugId() {
        return bugId;
    }
}
