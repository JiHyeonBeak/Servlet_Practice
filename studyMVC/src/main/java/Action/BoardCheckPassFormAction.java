package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String url ="/board/boardCheckPass.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, respone);
		
	}

}
