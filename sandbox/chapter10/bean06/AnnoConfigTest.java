package chapter10.bean06;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnoConfigTest {

	ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
	
	@Test
	public void di(){
		assertNotNull(context.getBean(SampleDao.class));
		assertNotNull(context.getBean(SampleService.class));
	}
	
	@Test
	public void ioc(){
		assertNotNull(context.getBean(SampleService.class).dao);
	}
	
}
