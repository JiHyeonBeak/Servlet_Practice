package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;
import VO.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
		
		String num = request.getParameter("num");
		
		boardDAO dao = new boardDAO();
		dao.updateReadCount(num); //조회수 올리기
		
		BoardVO vo = dao.selectOneBoardByNum(num); //num으로 찾은 원하는 게시물의 정보를 vo에 저장
		
		request.setAttribute("board", vo);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, respone);
		
		
		
	}

}
