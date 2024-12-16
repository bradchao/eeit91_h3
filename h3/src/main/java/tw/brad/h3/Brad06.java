package tw.brad.h3;

import java.util.List;

import tw.brad.dao.MemberDao;
import tw.brad.model.BCrypt;
import tw.brad.model.Member;

public class Brad06 {

	public static void main(String[] args) {
//		Member member = new Member();
//		member.setAccount("test5");
//		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
//		member.setName("Test5");
//		
		MemberDao dao = new MemberDao();
//		dao.save(member);

//		try {
//			Member member = dao.getById(13);
//			System.out.println(member.getAccount());
//			
//			dao.delete(member);
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}

		try {
			List<Member> members = dao.getAll();
			for (Member member : members) {
				System.out.printf("%d : %s\n", member.getId(), member.getAccount());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("---");
		try {
			// HQL
			List<Member> members = dao.getWhere("FROM Member m WHERE m.name LIKE '%Brad%'");
			for (Member member : members) {
				System.out.printf("%d : %s\n", member.getId(), member.getAccount());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("---");
		try {
			// SQL
			List<Member> members = dao.getBySQL("SELECT * FROM member m WHERE m.name LIKE '%Brad%'");
			for (Member member : members) {
				System.out.printf("%d : %s\n", member.getId(), member.getAccount());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("---");

		try {
			Member member = dao.getById(8);
			System.out.println(member.getAccount());
			
			member.setAccount("I am 8");
			member.setPasswd(BCrypt.hashpw("654321", BCrypt.gensalt()));

			dao.update(member);
			System.out.println("Update OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
