package com.albenyuan.mybatis.mapper;

import com.albenyuan.mybatis.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectChildByFatherId(Long fatherId);

    List<Menu> selectTree();

    Menu selectTreeById(Long id);

    List<Menu> selectTreeByFatherId(Long fatherId);

    Menu selectDetailById(Long id);


}