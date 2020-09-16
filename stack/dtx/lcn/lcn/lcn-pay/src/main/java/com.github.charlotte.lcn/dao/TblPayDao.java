package com.github.charlotte.lcn.dao;

import com.github.charlotte.lcn.entity.TblPay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblPayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblPay record);

    int insertSelective(TblPay record);

    TblPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblPay record);

    int updateByPrimaryKey(TblPay record);
}