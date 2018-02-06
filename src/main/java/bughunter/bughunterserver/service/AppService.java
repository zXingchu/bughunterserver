package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.User;

import java.util.List;

public interface AppService {


    Boolean deleteApp(int id);

    int addApp(AppBaseInfo appBaseInfo);

    Boolean modifyApp(AppBaseInfo appBaseInfo);

    AppBaseInfo findApp(int id);

    List<AppBaseInfo> findAllAppsByUserId(int uid);

    List<AppBaseInfo> findAllApps();


}
