package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.model.repository.UserRepository;
import bughunter.bughunterserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean testLogin(int id, String pwd) {
        return null;
    }

    @Override
    public Boolean deleteUser(int id) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public Boolean modifyUser(User user) {
        return null;
    }

    @Override
    public User findUser(int id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
