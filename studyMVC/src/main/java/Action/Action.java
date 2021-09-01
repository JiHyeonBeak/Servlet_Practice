package Action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { //추상 메소드 정의를 위한 인터페이스, 모델 수행을 할 메소드를 동일한 이름으로 접근하기 위한 것
	public void execute(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException;
}
