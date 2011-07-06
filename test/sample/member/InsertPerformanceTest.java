package sample.member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;
import sample.domain.Member;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: keesun
 * Date: 11. 7. 5
 * Time: 오후 2:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class InsertPerformanceTest {

    @Autowired MemberServiceHibernateImpl memberServiceHibernate;
	@Autowired MemberServiceIbatisImpl memberServiceIbatis;

    @Before
    public void setUp(){
        memberServiceHibernate.flushAndClear();
        memberServiceIbatis.deleteAll();
    }

    @Test
    @Repeat(20)
    public void iBatis(){
        StopWatch stopWatch = new StopWatch();
        List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
            stopWatch.start();
			memberServiceIbatis.add(newMember);
            stopWatch.stop();
		}
        System.out.println("iBatis: insert 5000 complete!");
        System.out.println(stopWatch.shortSummary());
    }

    @Test
    @Repeat(20)
    public void hiebrnate(){
        StopWatch stopWatch = new StopWatch();
        List<Member> member5000 = MemberTestUtils.makeMember5000();
		for(Member newMember : member5000) {
            stopWatch.start();
			memberServiceHibernate.add(newMember);
//            memberServiceHibernate.flushAndClear();
            stopWatch.stop();
		}
        System.out.println("Hiebrnate: insert 5000 complete!");
        System.out.println(stopWatch.shortSummary());
    }




}
