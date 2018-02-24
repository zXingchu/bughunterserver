package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.vo.UserVO;
import org.json.JSONObject;

import java.util.List;

public interface UserService {

    int testLogin(int id, String pwd);

    int testLogin(String email, String pwd);

    Boolean deleteUser(int id);

    Boolean activeUser(int id);

    int addUser(User user);

    Boolean modifyUser(int id, JSONObject jsonObject);

    UserVO findUser(int id);

    List<UserVO> findAllUsers();

    boolean sendActiveEmail(String email);

    UserVO findByEmail(String email);

}
