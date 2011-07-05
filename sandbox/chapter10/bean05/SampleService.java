package chapter10.bean05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	@Autowired
	SampleDao sampleDao;

}
