package com.hito.htSpring.controller;

import com.hito.htSpring.Dao.ProvinceDao;
import com.hito.htSpring.entity.BaseProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Hito
 * @Date 2024/7/12
 */

@RestController
@RequestMapping("/store")
public class ProvinceController {

    @Autowired
    private ProvinceDao provinceDao;

    @RequestMapping("/province")
    public List<BaseProvince> getProvince() {
        return provinceDao.findAll();
    }
}
