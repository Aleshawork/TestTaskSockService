package com.example.socksservice.controller;

import com.example.socksservice.model.Sock;
import com.example.socksservice.service.SockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SockController {

    private final SockService sockService;

    @Autowired
    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("/income")
    public HttpStatus income(@RequestBody Sock sock){
        sockService.income(sock);
        return  HttpStatus.OK;
    }

    @PostMapping("/outcome")
    public HttpStatus outcome(@RequestBody Sock sock){
        sockService.outcome(sock);
        return HttpStatus.OK;
    }

    ///{operation}/{cottonPart}
    @GetMapping()
    public int findCount(@RequestParam("color")String color,
                         @RequestParam("operation")String operation,
                         @RequestParam("cottonPart")int cottonPart
                         ){
        return sockService.count(color,operation,cottonPart);
    }


}
