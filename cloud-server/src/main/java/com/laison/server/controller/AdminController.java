package com.laison.server.controller;

import com.laison.entity.Admin;
import com.laison.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/5 15:25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/list")
    public List<Admin> listAll() {
        return adminService.listAll();
    }
}
