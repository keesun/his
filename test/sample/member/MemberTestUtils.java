package sample.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sample.domain.Member;

public class MemberTestUtils {

	public static List<Member> makeMember5000() {
		List<Member> member1000 = new ArrayList<Member>();
		for(int i = 0 ; i < 1000 ; i++){
			Member member = new Member();
			member.setId(i);
			member.setName("whiteship"+i);
			member.setJoined(new Date());
			member.setName1("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName2("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName3("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName4("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName5("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName6("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName7("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName8("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member.setName9("sddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssslkjfsldkjflskdjflskdjf");
			member1000.add(member);
		}
		return member1000;
	}
	
}
