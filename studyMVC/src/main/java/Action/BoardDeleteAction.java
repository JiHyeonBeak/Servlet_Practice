package Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String num = request.getParameter("num");
		boardDAO dao = new boardDAO();
		dao.deleteBoard(num);
		
		new BoardListAction().execute(request, respone);
		
	}

}
