package com.esiea.fr.arch.controllers;


import com.esiea.fr.arch.entity.JwtRequest;
import com.esiea.fr.arch.entity.JwtResponse;
import com.esiea.fr.arch.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	System.out.println(jwtService.createJwtToken(jwtRequest));
        return jwtService.createJwtToken(jwtRequest);
    }
}