package chapter10.bean11;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {
	
	String name;

	@Value("whiteship")
	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void init(){
		System.out.println("hi");
	}
	
	@PreDestroy
	public void end(){
		System.out.println("bye");
	}
	
}
