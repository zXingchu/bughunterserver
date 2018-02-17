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
        User user=userRepository.findOne(id);
        //TODO
        if(user.getPwd().equals(pwd))
            return true;
        return false;
    }

    @Override
    public Boolean deleteUser(int id) {
        userRepository.delete(id);
        //TODO
        return false;
    }

    @Override
    public int addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Boolean modifyUser(User user) {
        userRepository.save(user);
        //TODO
        return false;
    }

    @Override
    public User findUser(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean sendActiveEmail(String email) {
        //TODO
        return false;
    }
}
