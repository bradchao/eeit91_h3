package tw.brad.h3;

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
		
		try {
			Member member = dao.getById(13);
			System.out.println(member.getAccount());
			
			dao.delete(member);
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
		
	}

}
