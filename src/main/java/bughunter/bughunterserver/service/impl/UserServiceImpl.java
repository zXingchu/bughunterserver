package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.model.repository.UserRepository;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public int testLogin(int id, String pwd) {
        User user=userRepository.findOne(id);
        if(user==null)
            return -2;
        if(user.getStatus()== Constants.STATUS_NOT_ACTIVE)
            return -1;
        if(!user.getPwd().equals(pwd))
            return 0;
        else
            return 1;
    }

    @Override
    public int testLogin(String email, String pwd) {
        User user=userRepository.findUserByEmail(email);
        if(user==null)
            return -2;
        if(user.getStatus()== Constants.STATUS_NOT_ACTIVE)
            return -1;
        if(!user.getPwd().equals(pwd))
            return 0;
        else
            return 1;
    }

    @Override
    public Boolean deleteUser(int id) {
        try {
            userRepository.delete(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public int addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Boolean modifyUser(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
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

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
