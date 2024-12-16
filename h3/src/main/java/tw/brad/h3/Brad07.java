package tw.brad.h3;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.model.BCrypt;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class Brad07 {

	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Member member = new Member();
			member.setAccount("tony5");
			member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
			member.setName("Tony5");
			
			MemberInfo info = new MemberInfo();
			info.setTel("7654321");
			info.setBirthday("1999-01-02");
			
			member.setMemberInfo(info);
			
			session.persist(member);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

}
