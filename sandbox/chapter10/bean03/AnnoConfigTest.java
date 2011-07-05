package chapter10.bean03;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnoConfigTest {

	@Test
	public void di(){
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		assertNotNull(context.getBean(SampleDao.class));
		assertNotNull(context.getBean(SampleService.class));
	}
	
}
