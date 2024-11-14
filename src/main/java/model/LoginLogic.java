package model;
import dao.UserDAO;
public class LoginLogic {
	public boolean execute(String name,String pass) {
		boolean boo;
		UserDAO dao = new UserDAO();
		boo = dao.UserLogin(name,pass);

		if (boo) {
			return true;
		}else {
			return false;
		}
		
		//元々のコード
//		if (user.getPass().equals("1234")) {
//			return true;
//		}
//		return false;

	}
}
