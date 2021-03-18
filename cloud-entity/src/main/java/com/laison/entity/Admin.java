package com.laison.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author sdp
 * @since 2021-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String phone;

    private String telephone;

    private String address;

    private Boolean enable;

    private String username;

    private String password;

    private String userFace;

    private String remark;
}
