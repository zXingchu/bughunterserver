package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.model.repository.UserRepository;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.until.RandonNumberUtils;
import bughunter.bughunterserver.vo.ResultMessage;
import bughunter.bughunterserver.vo.UserVO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public int testLogin(int id, String pwd) {
        User user = userRepository.findOne(id);
        if (user == null)
            return -2;
        if (user.getStatus() == Constants.STATUS_NOT_ACTIVE)
            return -1;
        if (!user.getPwd().equals(pwd))
            return 0;
        else
            return 1;
    }

    @Override
    public int testLogin(String email, String pwd) {
        User user = userRepository.findUserByEmail(email);
        if (user == null)
            return -2;
        if (user.getStatus() == Constants.STATUS_NOT_ACTIVE)
            return -1;
        if (!user.getPwd().equals(pwd))
            return 0;
        else
            return 1;
    }

    @Override
    public Boolean deleteUser(int id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public Boolean activeUser(int id) {
        if (!userRepository.exists(id))
            return false;
        User user = userRepository.findOne(id);
        user.setStatus(Constants.STATUS_ACTIVE);
        userRepository.save(user);
        return true;
    }

    @Override
    public int addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Boolean modifyUser(int id, JSONObject jsonObject) {
        try {
            User user = userRepository.findOne(id);
            if (user == null)
                return false;
            user.setName(jsonObject.getString(Constants.NAME));
            user.setTeleNumber(jsonObject.getString(Constants.TeleNumber));
            user.setEmail(jsonObject.getString(Constants.EMAIL));
            if (jsonObject.has(Constants.PWD))
                user.setPwd(jsonObject.getString(Constants.PWD));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public UserVO findUser(int id) {
        if (!userRepository.exists(id))
            return null;
        User user = userRepository.findOne(id);
        return new UserVO(user);
    }

    @Override
    public List<UserVO> findAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserVO> userVOList = new ArrayList<UserVO>(userList.size());
        for (User user : userList) {
            UserVO userVO = new UserVO(user);
            userVOList.add(userVO);
        }
        return userVOList;
    }

    @Override
    public String sendActiveEmail(String email) {
        //TODO 发送内容待改善
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Constants.SEND_EMAIL_FROM);//发送者.
        message.setTo(email);//接收者.
        message.setSubject("BugHunter验证码（邮件主题）");//邮件主题.
        String vc = RandonNumberUtils.getRandonString(6);
        message.setText("您的验证码：" + vc);//邮件内容.
        mailSender.send(message);//发送邮件
        return vc;
    }

    @Override
    public UserVO findByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null)
            return null;
        return new UserVO(user);
    }
}
