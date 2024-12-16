package tw.brad.h3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.model.Member;

public class Brad05 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM member";
			
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			List<Member> list = query.getResultList();
			for (Member member : list) {
				System.out.printf("%d : %s : %s : %s\n", 
						member.getId(), member.getAccount(),
						member.getPasswd(), member.getName());
			}
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
