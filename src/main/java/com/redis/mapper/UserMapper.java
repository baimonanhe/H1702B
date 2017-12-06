package com.redis.mapper;

import java.util.List;

import com.redis.pojo.User;

public interface UserMapper {

	List<User> find(Integer sid);

}
