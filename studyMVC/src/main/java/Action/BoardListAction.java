package Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;
import VO.boardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String url = "/board/boardList.jsp";
		
		boardDAO dao = new boardDAO();
		
		List<boardVO> list = dao.selectAllBoard();
		
		request.setAttribute("boardList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, respone);
		
	}

}
