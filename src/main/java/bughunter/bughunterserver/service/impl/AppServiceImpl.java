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
        return null;
    }

    @Override
    public int addApp(AppBaseInfo appBaseInfo) {
        return 0;
    }

    @Override
    public Boolean modifyApp(AppBaseInfo appBaseInfo) {
        return null;
    }

    @Override
    public AppBaseInfo findApp(int id) {
        return null;
    }

    @Override
    public List<AppBaseInfo> findAllApps() {
        return null;
    }

}
