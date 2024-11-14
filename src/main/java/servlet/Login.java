package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		
		//入力値の取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//User.javaのインスタンス生成
		User user = new User(name,pass);
		
		//LoginLogic.javaのインスタンス生成
		LoginLogic loginLogic = new LoginLogic();
		
		//ログイン可否の判定
		boolean isLogin = loginLogic.execute(name,pass);
		
		//ログイン可能な場合
		if(isLogin) {
			//セッションの取得
			HttpSession session = request.getSession();
			//セッションへの保存
			session.setAttribute("loginUser",user);
		}
		//ログイン成功画面への遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
