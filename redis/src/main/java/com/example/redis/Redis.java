package com.example.redis;

import redis.clients.jedis.Jedis;

public class Redis {
	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("redis://default:BKYiUHXCZv5rL1hI78j5Ph92kog2ZU6g@redis-18698.c280.us-central1-2.gce.redns.redis-cloud.com:18698");
		System.out.println("Connection to server sucessfully");
		// check whether server is running or not
		jedis.set("Sathwik", "Teacher");
		System.out.println("Server is running: " + jedis.ping());
		System.out.println(jedis.get("Sathwik"));
	}
}
