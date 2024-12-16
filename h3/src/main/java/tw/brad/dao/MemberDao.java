package tw.brad.dao;

import java.util.List;

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
	
	public List<Member> getAll() throws Exception {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "FROM Member";
			return session.createQuery(hql, Member.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception();
		}		
	}

	public List<Member> getWhere(String hql) throws Exception {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery(hql, Member.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception();
		}		
	}

	public List<Member> getBySQL(String sql) throws Exception {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createNativeQuery(sql, Member.class).getResultList();
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
	
	public void update(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(member);
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	
}
