package org.slipp.passion.imsi.sign.service;

import java.util.ArrayList;

import org.slipp.passion.imsi.sign.mapper.UserSignMapper;
import org.slipp.passion.imsi.sign.vo.UserSignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserSignService {

    private UserSignMapper userSignMapper;

    public void setUserSignMapper(UserSignMapper userSignMapper) {
        this.userSignMapper = userSignMapper;
    }


    public ArrayList<UserSignVo> getList() {
        return this.userSignMapper.getList();
    }
    
    public UserSignVo getUser(String id) {
        return this.userSignMapper.getUser(id);
    }
    
    public void insert (UserSignVo userSignVo) {
        userSignMapper.insert(userSignVo);
    }
}
