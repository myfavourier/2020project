package com.team.bank.mapper;

import org.apache.ibatis.annotations.*;
import com.team.bank.model.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Insert("INSERT INTO lq_userinfo(username, mobile, email, cardnum) VALUES (#{name}, #{mobile}, #{email}, #{cardnum})")
    int addUserInfo(LqUserInfo lqUserInfo);

    @Select("SELECT COUNT(*) FROM lq_userinfo WHERE mobile = #{mobile} OR username = #{username}")
    Integer isUsed(String mobile,String username);

    @Insert("INSERT INTO lq_user(username,pd) VALUES (#{name}, #{password})")
    int addUserPwd(LqUserInfo lqUserInfo);

    @Select("SELECT COUNT(*) FROM lq_user WHERE (username = #{username} AND pd = #{password})")
    Integer checkLogin(LqUser lqUser);

    @Select("SELECT mobile from lq_userinfo WHERE username = #{username}")
    String getMobile(LqUser lqUser);

    @Select("SELECT * from lq_userinfo WHERE mobile = #{mobile}")
    LqUserInfo getCommonInfo(String mobile);

    @Select("SELECT * from lq_asset WHERE mobile = #{mobile}")
    LqAsset getAssetInfo(String mobile);

    @Select("SELECT * FROM lq_expense WHERE mobile = #{mobile}")
    List<LqExpense> getExpennseInfo(String mobile);

    @Select("SELECT username FROM lq_userinfo WHERE mobile = #{mobile}")
    String getUserName(String mobile);

    @Select("SELECT pd FROM lq_user WHERE username = #{username}")
    String getPassWord(String username);
}
