package tw.brad.h3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.model.Member;

public class Brad02 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String sql = "INSERT INTO member (account,passwd,name) VALUES (:account, :passwd, :name)";
			
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			query.setParameter("account", "test3");
			query.setParameter("passwd", "123456");
			query.setParameter("name", "Test3");
			
			int n = query.executeUpdate();
			
			transaction.commit();
			
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
