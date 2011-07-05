package sample.member;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.domain.Member;

@Repository
public class MemberDaoHibernate implements MemberDao{
	
	@Autowired SessionFactory sessionFactory;

	public void add(Member member) {
		getSession().save(member);
	}

	public void delete(int id) {
		getSession().createQuery("delete from Member where id = ?")
			.setInteger(0, id)
			.executeUpdate();
	}

	public Member get(int id) {
		return (Member) getCriteria()
			.add(Restrictions.eq("id", id))
			.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Member> list() {
		return getCriteria().list();
	}

	public void update(Member member) {
		getSession().update(member);
	}

	private Criteria getCriteria() {
		return getSession().createCriteria(Member.class);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void deleteAll() {
		getSession().createQuery("delete from Member");
	}


    public void clear() {
        getSession().clear();
    }
}
