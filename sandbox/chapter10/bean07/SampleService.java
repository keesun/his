package chapter10.bean07;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	@Resource(name="sampleDao")
	SampleDao sampleDao;

}
