package chapter10.bean10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Provider;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ScopeTest {

	@Test
	public void singletonToPrototype(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				PrototypeBean2.class, SingletonBean2.class);
		Set<PrototypeBean2> bean = new HashSet<PrototypeBean2>();
		
		bean.add(ac.getBean(PrototypeBean2.class));
		bean.add(ac.getBean(PrototypeBean2.class));
		assertThat(bean.size(), is(2));
		
		bean.add(ac.getBean(SingletonBean2.class).getBean1());
		assertThat(bean.size(), is(3));
		bean.add(ac.getBean(SingletonBean2.class).getBean1());
		assertThat(bean.size(), is(4));
	}
	
	@Scope("prototype")
	static class PrototypeBean2 {
		
	}
	
	static class SingletonBean2 {
		@Autowired Provider<PrototypeBean2> prototypeBeanProvider;
		
		PrototypeBean2 bean1;

		public PrototypeBean2 getBean1() {
			return prototypeBeanProvider.get();
		}

		public void setBean1(PrototypeBean2 bean1) {
			this.bean1 = bean1;
		}
	}
	
	

}
