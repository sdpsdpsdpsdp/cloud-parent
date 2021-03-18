package com.laison.server.service;


import com.laison.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sdp
 * @since 2021-03-02
 */
public interface AdminService {
    List<Admin> listAll();
}
