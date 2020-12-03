package sppringBootStudy001.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		updateMenoryService.tramsfer();
		return menoryMapper.selectByPrimaryKey(0).getName();
	}

}
