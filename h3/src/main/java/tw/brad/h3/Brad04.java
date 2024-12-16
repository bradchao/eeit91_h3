package tw.brad.h3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.model.Member;

public class Brad04 {

	public static void main(String[] args) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM member";
			
			NativeQuery query = session.createNativeQuery(sql);
			List list = query.getResultList();
			for (Object row : list) {
				Object[] row2 = (Object[])row;
				Integer id =  (Integer)row2[0];
				String account =  (String)row2[1];
				String passwd =  (String)row2[2];
				String name =  (String)row2[3];
				System.out.printf("%d : %s : %s : %s\n", id, account, passwd, name);
			}
			
			transaction.commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
