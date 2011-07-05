package chapter10.bean08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {
	
	String name;

	@Value("whiteship")
	public void setName(String name) {
		this.name = name;
	}

}
