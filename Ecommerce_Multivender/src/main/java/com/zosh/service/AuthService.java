package com.zosh.service;

import com.zosh.request.LoginRequest;
import com.zosh.response.AuthResponse;
import com.zosh.response.SignupRequest;

//we will write implementation of  AuthSerivice in IMp package
public interface AuthService {
     void   sentLoginOtp(String email) throws Exception;
     String createUser(SignupRequest req) throws Exception;
    AuthResponse signing(LoginRequest req);

}
