

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/test")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //인코딩 설정
		PrintWriter pw = response.getWriter(); //화면에 출력하기 위해 PrintWriter 객체 선언
		HttpSession session = request.getSession(); //세션 생성을 위한 객체 선언
		
		pw.print("세션 아이디 : "+session.getId()+"<br>");
		pw.print("최초 세션 생성 시각 : "+new Date(session.getCreationTime())+"<br>");
		pw.print("최근 세션 접근 시각 : "+new Date(session.getLastAccessedTime())+"<br>");
		pw.print("세션 유효 시간 : " +session.getMaxInactiveInterval()+"<br>");
		
		if(session.isNew()) {
			pw.print("새 새션이 생성되었습니다.");
		}
		session.invalidate(); //세션 삭제
	}

}
