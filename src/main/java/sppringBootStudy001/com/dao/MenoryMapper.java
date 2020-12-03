package sppringBootStudy001.com.dao;

import org.springframework.stereotype.Repository;

import sppringBootStudy001.com.model.Menory;

@Repository
public interface MenoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menory record);

    int insertSelective(Menory record);

    Menory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menory record);

    int updateByPrimaryKey(Menory record);
}