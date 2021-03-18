package com.laison.server.service.impl;

import com.laison.entity.Admin;
import com.laison.server.mapper.AdminMapper;
import com.laison.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sdp
 * @since 2021-03-02
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Admin> listAll() {
        return adminMapper.selectAll();
    }
}
