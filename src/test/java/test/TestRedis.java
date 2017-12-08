package test;

import java.util.Collection;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestRedis {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		Map<String, CacheManager> map = context
				.getBeansOfType(CacheManager.class);

		System.out.println(context.getBean(RedisTemplate.class));
		RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
		for (String string : map.keySet()) {
			CacheManager cacheManager = map.get(string);
			System.out.println(cacheManager);
			System.out.println(cacheManager.getCacheNames());
			Collection<String> cacheNames = cacheManager.getCacheNames();
			for (String string2 : cacheNames) {
				System.out.println(cacheManager.getCache(string2));
			}

		}
		context.close();
	}
}
