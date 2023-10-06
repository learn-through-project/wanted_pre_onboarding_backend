package com.han.controller;

import com.han.constants.EndPoint;
import com.han.dto.CompanyCreateDto;
import com.han.model.Company;
import com.han.service.CompanyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @PostMapping(EndPoint.COMPANY)
  public ResponseEntity<Boolean> createNewCompany(@Valid @RequestBody CompanyCreateDto dto) {
    Company company = companyService.createCompany(dto);
    Boolean isSuccess = company != null;
    return new ResponseEntity<>(isSuccess, HttpStatus.CREATED);
  }
}