package com.nurung.mongsil.controller;

import com.nurung.mongsil.config.TokenProvider;
import com.nurung.mongsil.domain.User;
import com.nurung.mongsil.domain.UserDTO;
import com.nurung.mongsil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController
@RequestMapping("/mongsil/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;
    private  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입
    @PostMapping("/signUp")
    public ResponseEntity create(@RequestBody User vo) {
        User user = User.builder()
                .id(vo.getId())
                .password(passwordEncoder.encode(vo.getPassword()))
                .name(vo.getName())
                .phone(vo.getPhone())
                .zonecode(vo.getZonecode())
                .address(vo.getAddress())
                .role("ROLE_USER")
                .build();
        User result = userService.create(user);
        UserDTO responseDTO = UserDTO.builder()
                .id(result.getId())
                .name(result.getName())
                .build();
        return ResponseEntity.ok().body(responseDTO);

    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User vo) {
        User user = userService.login(vo.getId(), vo.getPassword(), passwordEncoder);
        if (user != null) {
            String token = tokenProvider.create(user);
            UserDTO responseDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    // 회원 전체 보기
    @GetMapping("/user")
    public ResponseEntity<List<User>> select() {
        List<User> list = userService.select();
        return ResponseEntity.ok().body(list);
    }

    // 회원만 1개보기
    @GetMapping("/user/{id}")
    public ResponseEntity<User> select(@PathVariable("id") String id) {
        User vo = userService.select(id);
        return ResponseEntity.status(HttpStatus.OK).body(vo);
    }

    // 회원 수정
    @PutMapping("/user")
    public ResponseEntity update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {

        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
