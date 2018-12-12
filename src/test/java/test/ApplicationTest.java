package test;

import com.djl.Application;
import com.djl.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试用例：嵌入式的servlet
 * @author     笨笨AA制
 * @createDate 2018年4月22日
 * @fileName   ApplicationTest.java
 * @desc
 */
@RunWith(SpringRunner.class)//spring环境运行
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
	@Autowired
	private RedisService redisService;
	@Test
	public void testHello() {
		redisService.cachePut("java", "redis hello","djl");
		System.out.println("hello");
		Assert.assertEquals("redis hello", redisService.cacheResult("java", "djl"));
	}
}