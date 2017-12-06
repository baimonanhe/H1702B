package com.redis.dao;

public interface JedisClient {
	
	String set(Integer sid,String value);
	String get(String key);
	String hget(String hkey, String key);
	long hset(String hkey, String key, String value);
	long incr(String key);
	long expire(String key, int second);
	long ttl(String key);
	long del(String key);
	long hdel(String hkey, String key);
}
