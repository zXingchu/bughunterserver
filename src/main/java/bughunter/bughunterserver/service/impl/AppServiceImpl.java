package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.repository.AppBaseRepository;
import bughunter.bughunterserver.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppServiceImpl implements AppService{

    @Autowired
    AppBaseRepository appBaseRepository;

    @Override
    public Boolean deleteApp(int id) {
        appBaseRepository.delete(id);
        return null;
    }

    @Override
    public int addApp(AppBaseInfo appBaseInfo) {
        appBaseInfo=appBaseRepository.save(appBaseInfo);
        return appBaseInfo.getId();
    }

    @Override
    public Boolean modifyApp(AppBaseInfo appBaseInfo) {
        appBaseRepository.save(appBaseInfo);
        return null;
    }

    @Override
    public AppBaseInfo findApp(int id) {
        return appBaseRepository.findOne(id);
    }

    @Override
    public List<AppBaseInfo> findAllAppsByUserId(int uid) {
        return null;
    }

    @Override
    public List<AppBaseInfo> findAllApps() {
        //TODO
        return appBaseRepository.findAll();
    }

}
