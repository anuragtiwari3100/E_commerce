package com.zosh.controller;

import com.zosh.domain.USER_ROLE;
import com.zosh.model.User;
import com.zosh.model.VerificationCode;
import com.zosh.repository.UserRepository;
import com.zosh.request.LoginOtpRequest;
import com.zosh.request.LoginRequest;
import com.zosh.response.ApiResponse;
import com.zosh.response.AuthResponse;
import com.zosh.response.SignupRequest;
import com.zosh.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private  final UserRepository userRepository;
    private  final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse>  createUserHandler(@RequestBody SignupRequest req) throws Exception {

   String jwt = authService.createUser(req);
        AuthResponse res = new AuthResponse();
        res.setJwt((jwt));
        res.setMessage("register success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

    return  ResponseEntity.ok(res);
    }

    @PostMapping("/sent/login/-signup-otp")
    public ResponseEntity<ApiResponse>  sendOtpHandler(@RequestBody LoginOtpRequest req) throws Exception {
       authService.sentLoginOtp(req.getEmail(),req.getRole());
        ApiResponse res = new ApiResponse();
        res.setMessage("otp sent successfully");
        return  ResponseEntity.ok(res);
    }

    @PostMapping("/signing")
    public ResponseEntity<AuthResponse>  loginHandler(@RequestBody LoginRequest req) throws Exception {
        authService.signing(req);
        AuthResponse authResponse = authService.signing(req);
        return  ResponseEntity.ok(authResponse);
    }
}
