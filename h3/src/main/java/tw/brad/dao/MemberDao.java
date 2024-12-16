package tw.brad.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.h3.HibernateUtil;
import tw.brad.model.Member;

public class MemberDao {

	public void save(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Member getById(int id) throws Exception {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Member.class, id);
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}
	
	
	public void delete(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.remove(member);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	
	
	
}
