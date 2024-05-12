package com.org.hrms.service;

import com.org.hrms.dto.LoginDto;
import com.org.hrms.entity.Employee;
import com.org.hrms.exception.EntityNotFoundException;
import com.org.hrms.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final EmployeeRepository employeeRepository;

  private final PasswordEncoder passwordEncoder;

  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
      EmployeeRepository employeeRepository,
      AuthenticationManager authenticationManager,
      PasswordEncoder passwordEncoder
  ) {
    this.authenticationManager = authenticationManager;
    this.employeeRepository = employeeRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Employee signup(LoginDto input) {
    Employee user = new Employee();
    user.setEmail(input.getEmail());
    user.setPassword(passwordEncoder.encode(input.getPassword()));


    return employeeRepository.save(user);
  }



  public Employee authenticate(LoginDto loginDto) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginDto.getEmail(),
              loginDto.getPassword()
          )
      );
    } catch (AuthenticationException e) {
      throw EntityNotFoundException.employee("Invalid email or password");
    }

    return employeeRepository.findByEmail(loginDto.getEmail())
        .orElseThrow(() ->  EntityNotFoundException.employee("Employee not found"));
  }




}