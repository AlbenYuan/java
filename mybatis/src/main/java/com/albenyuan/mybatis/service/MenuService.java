package com.albenyuan.mybatis.service;

import com.albenyuan.mybatis.entity.Menu;

import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-08-03 16:48
 */
public interface MenuService {

    List<Menu> findTree();

}
