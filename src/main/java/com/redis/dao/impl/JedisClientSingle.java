package com.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.redis.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient{
	@Autowired
	private JedisPool jedisPool;
	
	public String set(Integer sid,String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set("sid",value);
		jedis.close();
		return string;
	}

	public String get(String key) {
		// TODO Auto-generated method stub
		Jedis jedis= jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	public String hget(String hkey, String key) {
		// TODO Auto-generated method stub
		Jedis jedis= jedisPool.getResource();
		String string = jedis.hget(hkey,key);
		jedis.close();
		return string;
	}

	public long hset(String hkey, String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey,key, value);
		jedis.close();
		return result;
	}

	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

}
