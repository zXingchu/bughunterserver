package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.AppMember;
import bughunter.bughunterserver.model.repository.AppBaseRepository;
import bughunter.bughunterserver.model.repository.AppMemberRepository;
import bughunter.bughunterserver.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
    public Boolean modifyApp(AppBaseInfo appBaseInfo) {
        try {
            appBaseRepository.save(appBaseInfo);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public AppBaseInfo findApp(int id) {
        return appBaseRepository.findOne(id);
    }

    @Override
    public List<AppBaseInfo> findAllAppsByUserId(int uid) {
        List<AppMember> appMemberList=appMemberRepository.findAllByUId(uid);
        List<AppBaseInfo> appBaseInfoList=new ArrayList<AppBaseInfo>(appMemberList.size());
        for (AppMember appMember:appMemberList) {
            AppBaseInfo appBaseInfo=appBaseRepository.findOne(appMember.getAppId());
            appBaseInfoList.add(appBaseInfo);
        }
        return appBaseInfoList;
    }

    @Override
    public List<AppBaseInfo> findAllApps() {
        return appBaseRepository.findAll();
    }

}
