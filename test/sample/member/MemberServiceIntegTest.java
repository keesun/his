package sample.member;

import java.util.List;

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
public class MemberServiceIntegTest {
	
	@Autowired MemberServiceHibernateImpl memberServiceHibernate;
	@Autowired MemberServiceIbatisImpl memberServiceIbatis;
	
	@Test
	public void di(){
		
	}
	
	@Ignore
	@Test
	@Repeat(10)
	public void hibernate(){
		//GIVEN
		memberServiceHibernate.deleteAll();
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
			memberServiceHibernate.add(newMember);
		}
		System.out.println("insert 5000 complete!");
		
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0 ; i < 100 ; i++) {
			//WHEN
			List<Member> members = memberServiceHibernate.list();
//			//THEN
//			assertThat(members.size(), is(1000));
//			System.out.println(System.identityHashCode(members.get(0)));
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
	}
	
	@Ignore
	@Test
	@Repeat(10)
	public void iBatis(){
		//GIVEN
		memberServiceIbatis.deleteAll();
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
			memberServiceIbatis.add(newMember);
		}
		System.out.println("insert 5000 complete!");
		
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0 ; i < 100 ; i++) {
			//WHEN
			List<Member> members = memberServiceIbatis.list();
//			//THEN
//			assertThat(members.size(), is(1000));
//			System.out.println(System.identityHashCode(members.get(0)));
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
	}
	
	

}
