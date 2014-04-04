package org.slipp.passion.imsi.sign.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.slipp.passion.imsi.sign.vo.UserSignVo;

public interface UserSignMapper {
    final String SELECT_ALL = 
            "SELECT  member_no, login_id, login_pw "+
            "FROM    t_member";
    
    final String SELECT_ID = 
            "SELECT  login_id, login_pw "+
            "FROM    t_member "+
            "WHERE   login_id = #{login_id}";
    
    final String INSERT = 
            "INSERT INTO t_member (login_id, login_pw)"+
            "VALUES (#{login_id}, #{login_pw})";
    
    @Select(SELECT_ALL)
    @Results(value = {
        @Result(property="member_no", column="MEMBER_NO"),
        @Result(property="login_id", column="LOGIN_ID"),
        @Result(property="login_pw", column="LOGIN_PW"),
    })
    ArrayList<UserSignVo> getList();
    
    @Select(SELECT_ID)
    @Results(value = {
            @Result(property="member_no", column="MEMBER_NO"),
            @Result(property="login_id", column="LOGIN_ID"),
            @Result(property="login_pw", column="LOGIN_PW"),
        })
    UserSignVo getUser(@Param("login_id") String login_id);
    
    @Insert(INSERT)
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insert (UserSignVo userSignVo);
}
