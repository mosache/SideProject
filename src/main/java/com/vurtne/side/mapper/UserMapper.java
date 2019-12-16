package com.vurtne.side.mapper;

import com.vurtne.side.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("Select * from t_user where id = #{id}")
    User getUserByID(Long id);

    @Select("Select * from t_user where username = #{username}")
    User getUserByUserName(String username);
}
