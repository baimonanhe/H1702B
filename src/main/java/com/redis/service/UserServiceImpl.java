package com.redis.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redis.dao.JedisClient;
import com.redis.mapper.UserMapper;
import com.redis.pojo.User;
import com.redis.util.JsonUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	@RequestMapping("/list")
	public List<User> find(Integer sid) {
		// TODO Auto-generated method stub
		//从缓存中取内容 
				try {
					String result = jedisClient.get(sid + "");
					if (!StringUtils.isBlank(result)) {
						//把字符串转换成list
						List<User> resultList = JsonUtils.jsonToList(result, User.class);
						return resultList;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		//在数据库里查询		
		List<User> user = userMapper.find(sid);
		try {
			//转换成json数据
			String string = JsonUtils.objectToJson(user);
			//添加到redis
			jedisClient.set(sid, string);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

}
