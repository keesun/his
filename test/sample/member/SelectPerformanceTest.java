package sample.member;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import sample.domain.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class SelectPerformanceTest {
	
	@Autowired MemberServiceHibernateImpl memberServiceHibernate;
	@Autowired MemberServiceIbatisImpl memberServiceIbatis;

    @Before
    public void setUp(){
        memberServiceHibernate.flushAndClear();
        memberServiceIbatis.deleteAll();
    }

	@Test
    @Repeat(10)
	public void hibernate(){
		//GIVEN
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
			memberServiceHibernate.add(newMember);
		}
        memberServiceHibernate.flushAndClear();
		System.out.println("Hibernate: insert 5000 complete!");

        //WHEN
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0 ; i < 10 ; i++) {
			List<Member> members = memberServiceHibernate.list();
		}
        memberServiceHibernate.flushAndClear();
		watch.stop();

		//THEN
        System.out.println(watch.prettyPrint());
	}

	@Test
    @Repeat(10)
	public void iBatis(){
		//GIVEN
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
			memberServiceIbatis.add(newMember);
		}
		System.out.println("iBatis: insert 5000 complete!");

        //WHEN
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0 ; i < 10 ; i++) {
			List<Member> members = memberServiceIbatis.list();
		}
		watch.stop();
        //THEN
		System.out.println(watch.prettyPrint());
	}

}
