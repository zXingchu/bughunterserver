package bughunter.bughunterserver.factory;

import bughunter.bughunterserver.model.entity.*;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;

public class VOFactory {

    public static AppBaseInfoVO getAppBaseInfoVO(AppBaseInfo appBaseInfo){
        if(appBaseInfo==null)
            return null;
        AppBaseInfoVO appBaseInfoVO=new AppBaseInfoVO(appBaseInfo);
        return appBaseInfoVO;
    }

    public static UserVO getUserVO(User user){
        if(user==null)
            return null;
        UserVO userVO=new UserVO(user);
        return userVO;
    }

    public static AppMemberVO getAppMemberVO(AppMember appMember){
        if(appMember==null)
            return null;
        AppMemberVO appMemberVO=new AppMemberVO(appMember);
        return appMemberVO;
    }

    public static BugBaseInfoVO getBugBaseInfoVO(BugBaseInfo bugBaseInfo){
        if(bugBaseInfo==null)
            return null;
        BugBaseInfoVO bugBaseInfoVO=new BugBaseInfoVO(bugBaseInfo);
        return bugBaseInfoVO;
    }

    public static BugConsoleLogVO getBugConsoleLogVO(BugConsoleLog bugConsoleLog){
        if(bugConsoleLog==null)
            return null;
        BugConsoleLogVO bugConsoleLogVO=new BugConsoleLogVO(bugConsoleLog);
        return bugConsoleLogVO;
    }

    public static BugDeviceInfoVO getBugDeviceInfoVO(BugDeviceInfo bugDeviceInfo){
        if(bugDeviceInfo==null)
            return null;
        BugDeviceInfoVO bugDeviceInfoVO=new BugDeviceInfoVO(bugDeviceInfo);
        return bugDeviceInfoVO;
    }

    public static BugNetRequestVO getBugNetRequestVO(BugNetRequest bugNetRequest){
        if(bugNetRequest==null)
            return null;
        BugNetRequestVO bugNetRequestVO=new BugNetRequestVO(bugNetRequest);
        return bugNetRequestVO;
    }

    public static BugOperateStepVO getBugOperateStepVO(BugOperateStep bugOperateStep){
        if(bugOperateStep==null)
            return null;
        BugOperateStepVO bugOperateStepVO=new BugOperateStepVO(bugOperateStep);
        return bugOperateStepVO;
    }

    public static BugUserDataVO getBugUserDataVO(BugUserData bugUserDatag){
        if(bugUserDatag==null)
            return null;
        BugUserDataVO bugUserDataVO=new BugUserDataVO(bugUserDatag);
        return bugUserDataVO;
    }

}
