package sample.member;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sample.common.DBUnitSupport;
import sample.domain.Member;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
@Transactional
public class MemberDaoJdbcTest extends DBUnitSupport {
	
	@Autowired MemberDaoJdbc memberDao;
	
	@Test
	public void di(){
		assertThat(memberDao, is(notNullValue()));
	}
	
	@Ignore
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
	
	@Ignore
	@Test
	public void searchByName(){
		insertXmlData("testData.xml");
		assertThat(memberDao.list().size(), is(2));
	}

}
