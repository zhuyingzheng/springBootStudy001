package sppringBootStudy001.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sppringBootStudy001.com.dao.MenoryMapper;
import sppringBootStudy001.com.model.Menory;
import sppringBootStudy001.com.service.UpdateMenoryService;

@Service
public class UpdateMenoryServiceImpl implements UpdateMenoryService{
	
	@Autowired
	private MenoryMapper menoryMapper;
	
	@Transactional
	@Override
	public void tramsfer() {
		Menory record = new Menory();
		record.setId(0);
		record.setName("王二麻");
		record.setMenory(60);
		menoryMapper.updateByPrimaryKey(record);
		
		int i = 10/0;
		
		record.setId(0);
		record.setName("张三");
		record.setMenory(90);
		menoryMapper.updateByPrimaryKey(record);
		
	}
	
}
