package chapter10.bean05;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class Bean05Test {

	@Autowired SampleDao dao;
	@Autowired SampleService service;
	
	@Test
	public void di(){
		assertNotNull(dao);
		assertNotNull(service);
	}
	
	@Test
	public void ioc(){
		assertNotNull(service.sampleDao);
	}
	
}
