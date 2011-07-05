package sample.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.domain.Member;

@Service
@Transactional
public class MemberServiceIbatisImpl implements MemberService {
	
	@Autowired MemberDaoIbatis dao;

	public void add(Member member) {
		dao.add(member);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Member get(int id) {
		return dao.get(id);
	}

	public List<Member> list() {
		return dao.list();
	}

	public void update(Member member) {
		dao.update(member);
	}

	public void deleteAll() {
		dao.deleteAll();
	}
	
}
