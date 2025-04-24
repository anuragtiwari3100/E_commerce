package com.zosh.service;

import com.zosh.response.SignupRequest;

//we will write implementation of  AuthSerivice in IMp package
public interface AuthService {
     String createUser(SignupRequest req);


}
