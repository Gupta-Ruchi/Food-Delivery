package com.delivery.authenticationservice.controller;

import com.delivery.authenticationservice.domain.Users;
import com.delivery.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Users> register(@RequestBody Users users) throws Exception {
        String regEmail=users.getEmailId();
        if (regEmail!=null && !"".equals(regEmail)){
            Users userObj=authService.fetchUserByEmailId(regEmail);
            if(userObj != null){
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
        Users userObj=null;
        userObj=authService.saveUsers(users);
        return new ResponseEntity(userObj, HttpStatus.OK);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Users> login(@RequestBody Users users) throws Exception{
        String regEmail= users.getEmailId();
        String regPass= users.getPassword();
        Users userObj=null;
        if (regEmail != null && regPass != null){
            userObj=authService.fetchUserByEmailIdAndPassword(regEmail, regPass);
        }
        if (userObj==null){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity(userObj, HttpStatus.OK);
    }

}
