package bughunter.bughunterserver.service;

import bughunter.bughunterserver.model.entity.User;

import java.util.List;

public interface UserService {

    Boolean testLogin(int id, String pwd);

    Boolean deleteUser(int id);

    int addUser(User user);

    Boolean modifyUser(User user);

    User findUser(int id);

    List<User> findAllUsers();



}
