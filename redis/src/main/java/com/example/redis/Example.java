package com.example.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;

public class Example {
	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost", 6379);

		try {

			// Ping the server to check the connection
			System.out.println("Connection Successful: " + jedis.ping());

			jedis.hmset("AAPL", Map.of("Price", "$150", "volume", "10M", "market_cap", "$2.5T"));

			System.out.println("Details of the AAPL " + jedis.hgetAll("AAPL"));

			jedis.expire("AAPL", 60); // Expires in 10 seconds
			System.out.println("Expiration set for 'Name' (60 seconds)");

			// Simulate waiting to show TTL expiry (optional)
			Thread.sleep(61000); // Wait 11 seconds
			System.out.println("Value after expiration (AAPL): " + jedis.hgetAll("AAPL")); // Should print null

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connection
			jedis.close();
		}
	}
}