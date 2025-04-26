package com.zosh.controller;

import com.zosh.model.User;
import com.zosh.response.AuthResponse;
import com.zosh.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
      private final UserService userService;

      @GetMapping("/users/profiles")

    public ResponseEntity<User> createUserHandler(@RequestHeader("Authorization")String jwt)throws Exception{
          User user= userService.findUserByJwtToken(jwt);
          return ResponseEntity.ok(user);
      }

}
