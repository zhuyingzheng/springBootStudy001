package sppringBootStudy001.com.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sppringBootStudy001.com.dao.MenoryMapper;
import sppringBootStudy001.com.service.UpdateMenoryService;

@Controller
public class HelloController {
	
	@Autowired
	private MenoryMapper menoryMapper;
	
	@Autowired
	private UpdateMenoryService updateMenoryService;
	
//	@Autowired
//    private RedisTemplate<String, String> redisTemplate;
	
//	@Autowired
//	private Redisson redisson;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		updateMenoryService.tramsfer();
		return menoryMapper.selectByPrimaryKey(0).getName()+"8092";
	}

//	@RequestMapping("/redisLock")
//	@ResponseBody
//	public String redisLock() {
//		String port = "8092" ;
//		String lockKey = "stockLock";
//
//		//redisson获取锁对象
//		RLock redissonLock = redisson.getLock(lockKey);
//
//		try {
//			//加锁，相当于setnx（）并设置了锁失效时间
//			redissonLock.lock();
//			int stock = Integer.parseInt(redisTemplate.opsForValue().get("int"));
//			if(stock>0) {
//				int realStack = stock - 1;
//				redisTemplate.opsForValue().set("int", realStack+"");
//				return "库存扣减成功，剩余库存 " + realStack + "，服务端口" + port;
//			}else {
//				return "库存不足" + "，服务端口" + port;
//			}
//		} finally {
//			// 释放锁
//			redissonLock.unlock();
//		}
//
//	}
}
