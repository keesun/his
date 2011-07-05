package chapter10.bean11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class Bean11Test {

	@Autowired SampleDao dao;
	@Autowired SampleService service;
	
	@Autowired ApplicationContext applicationContext;
	@Autowired BeanFactory beanFactory;
	@Autowired ResourceLoader resourceLoader;
	@Autowired ApplicationEventPublisher applicationEventPublisher;
	@Autowired Properties systemProperties;
	@Autowired Properties systemEnvironment;
	
	@Test
	public void di(){
		assertNotNull(dao);
		assertNotNull(service);
	}
	
	@Test
	public void ioc(){
		assertNotNull(service.sampleDao);
	}
	
	@Test
	public void value(){
		assertThat(dao.name, is("whiteship"));
	}
	
	@Test
	public void autoRegit(){
		assertNotNull(applicationContext);
		assertNotNull(beanFactory);
		assertNotNull(resourceLoader);
		assertNotNull(applicationEventPublisher);
		assertNotNull(systemProperties);
		assertNotNull(systemEnvironment);
	}
	
}
