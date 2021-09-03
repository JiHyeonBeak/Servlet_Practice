package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;
import VO.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String url;
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		boardDAO dao = new boardDAO();
		BoardVO vo = dao.selectOneBoardByNum(num);
		
		
		
		if(vo.getPass().equals(pass)) {
			System.out.println("보드체크패스액션, 패스워드 일치");
			url="/board/checkSuccess.jsp";
		}else {
			url="/board/boardCheckPass.jsp";
			request.setAttribute("massage", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, respone);
		
	}

}
