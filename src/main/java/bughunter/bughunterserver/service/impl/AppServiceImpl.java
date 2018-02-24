package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.AppMember;
import bughunter.bughunterserver.model.repository.AppBaseRepository;
import bughunter.bughunterserver.model.repository.AppMemberRepository;
import bughunter.bughunterserver.service.AppService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.AppBaseInfoVO;
import bughunter.bughunterserver.vo.ResultMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService{

    @Autowired
    AppBaseRepository appBaseRepository;

    @Autowired
    AppMemberRepository appMemberRepository;

    @Override
    public Boolean deleteApp(int id) {
        try {
            appBaseRepository.delete(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public int addApp(AppBaseInfo appBaseInfo) {
        appBaseInfo=appBaseRepository.save(appBaseInfo);
        return appBaseInfo.getId();
    }

    @Override
    public Boolean modifyApp(int id, JSONObject jsonObject) {
        try {
            AppBaseInfo appBaseInfo=appBaseRepository.findOne(id);
            if(appBaseInfo==null)
                return false;
            appBaseRepository.save(appBaseInfo);
            appBaseInfo.setType(jsonObject.getString(Constants.TYPE));
            appBaseInfo.setName(jsonObject.getString(Constants.NAME));
            appBaseInfo.setSDKVersion(jsonObject.getDouble(Constants.SDK_VERSION));
            appBaseInfo.setmTime(new Date(new java.util.Date().getTime()));
            appBaseRepository.save(appBaseInfo);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public AppBaseInfoVO findApp(int id) {
        if(!appBaseRepository.exists(id))
            return null;
        AppBaseInfo appBaseInfo = appBaseRepository.findOne(id);
        return new AppBaseInfoVO(appBaseInfo);
    }

    @Override
    public List<AppBaseInfoVO> findAllAppsByUserId(int uid) {
        List<AppMember> appMemberList=appMemberRepository.findAllByUId(uid);
        if(appMemberList==null)
            return null;

        List<AppBaseInfo> appBaseInfoList=new ArrayList<AppBaseInfo>(appMemberList.size());
        for (AppMember appMember:appMemberList) {
            AppBaseInfo appBaseInfo=appBaseRepository.findOne(appMember.getAppId());
            appBaseInfoList.add(appBaseInfo);
        }

        List<AppBaseInfoVO> appBaseInfoVOList=new ArrayList<AppBaseInfoVO>(appBaseInfoList.size());
        for (AppBaseInfo appBaseInfo: appBaseInfoList) {
            AppBaseInfoVO appBaseInfoVO=new AppBaseInfoVO(appBaseInfo);
            appBaseInfoVOList.add(appBaseInfoVO);
        }
        return appBaseInfoVOList;
    }

    @Override
    public List<AppBaseInfoVO> findAllApps() {
        List<AppBaseInfo> appBaseInfoList = appBaseRepository.findAll();
        if(appBaseInfoList==null)
            return null;
        List<AppBaseInfoVO> appBaseInfoVOList=new ArrayList<AppBaseInfoVO>(appBaseInfoList.size());
        for (AppBaseInfo appBaseInfo: appBaseInfoList) {
            AppBaseInfoVO appBaseInfoVO=new AppBaseInfoVO(appBaseInfo);
            appBaseInfoVOList.add(appBaseInfoVO);
        }
        return appBaseInfoVOList;
    }

}
