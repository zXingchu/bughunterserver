package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.vo.AppBaseInfoVO;
import org.json.JSONObject;

import java.util.List;

public interface AppService {


    Boolean deleteApp(int id);

    int addApp(AppBaseInfo appBaseInfo);

    Boolean modifyApp(int id, JSONObject jsonObject);

    AppBaseInfoVO findApp(int id);

    List<AppBaseInfoVO> findAllAppsByUserId(int uid);

    List<AppBaseInfoVO> findAllApps();


}
