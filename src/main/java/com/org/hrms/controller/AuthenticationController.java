package com.org.hrms.controller;
import com.org.hrms.dto.LoginDto;
import com.org.hrms.dto.response.Data;
import com.org.hrms.dto.response.LoginResponse;
import com.org.hrms.entity.Employee;
import com.org.hrms.service.AuthenticationService;
import com.org.hrms.service.JwtService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrms/")
public class AuthenticationController {
  private final JwtService jwtService;

  private final AuthenticationService authenticationService;



  public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
    this.jwtService = jwtService;
    this.authenticationService = authenticationService;
  }

  @PostMapping("signup")
  public ResponseEntity<Employee> register(@RequestBody LoginDto registerUserDto) {
    Employee registeredUser = authenticationService.signup(registerUserDto);

    return ResponseEntity.ok(registeredUser);
  }


  @PostMapping("login")
  public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginDto) {
    Employee authenticatedUser = authenticationService.authenticate(loginDto);

    String jwtToken = jwtService.generateToken(authenticatedUser);
    Data data = Data.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();

    LoginResponse loginResponse =  LoginResponse.builder().status(true).message("Login Successful").data(data).build();

    return ResponseEntity.ok(loginResponse);
  }
}