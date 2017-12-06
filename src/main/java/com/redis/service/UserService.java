package com.redis.service;

import java.util.List;

import com.redis.pojo.User;

public interface UserService {

	List<User> find(Integer sid);

}
