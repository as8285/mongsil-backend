package com.nurung.mongsil.service;

import com.nurung.mongsil.domain.User;
import com.nurung.mongsil.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userdao;
    // 신규 가입하기
    public User create(User vo){
        return userdao.save(vo);
    }


    // 로그인

    public User login(String id,String password,PasswordEncoder encoder){

        User user = userdao.findById(id).orElse(null);
        if (user!= null && encoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }




    // 회원 전체 보기
    public List<User> select() {

        return userdao.findAll();
    }

// 회원 아이디 한개만 보기

    public User select(String id) {
        return userdao.findById(id).orElse(null);
    }
    public void update(User user) {
        if (userdao.existsById(user.getId())) {
            userdao.save(user);

        }
    }
    public void delete(String id) {
        if (userdao.existsById(id)) {
            userdao.deleteById(id);
        }

    }

}



