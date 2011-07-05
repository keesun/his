package sample.member;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import sample.common.DBUnitSupport;
import sample.domain.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
@Transactional
public class MemberDaoIbatisTest extends DBUnitSupport {

	@Autowired MemberDaoIbatis memberDao;
	
	@Test
	public void di(){
		assertThat(memberDao, is(notNullValue()));
	}
	
	@Test
	public void crud(){
		Member member = new Member();
		member.setId(1);
		member.setName("whiteship");
		member.setJoined(new Date());
		memberDao.add(member);
		assertThat(memberDao.list().size(), is(1));
		
		member.setName("기선");
		memberDao.update(member);
		assertThat(memberDao.get(1).getName(), is("기선"));
		
		memberDao.delete(1);
		assertThat(memberDao.list().size(), is(0));
	}
	
	@Test
	@Repeat(50)
	public void add5000(){
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		StopWatch watch = new StopWatch();
		watch.start();
		for(Member newMember : member5000) {
			memberDao.add(newMember);
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
		
		assertThat(memberDao.list().size(), is(1000));
	}

	@Test
	@Repeat(10)
	public void select5000(){
		//GIVEN
		memberDao.deleteAll();
		List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
			memberDao.add(newMember);
		}
		System.out.println("insert 5000 complete!");
		
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0 ; i < 100 ; i++) {
			//WHEN
			List<Member> members = memberDao.list();
//			//THEN
//			assertThat(members.size(), is(1000));
//			System.out.println(System.identityHashCode(members.get(0)));
			
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
	}
	

}
