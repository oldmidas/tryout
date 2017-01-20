package week1day2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/req")
public class RequestDemoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String[] languages = req.getParameterValues("lan");
		//checkbox는 입력값이 없으면 값을 전달하지 않는다, 그러므로 if문으로 null인 상황을 체크해야한다.
		if (languages != null) {
			for (String lang : languages) {
				System.out.println(lang);
			}			
		}
		//text는 입력값이 없어도 전달이된다. checkbox처럼 if문이 필요하지 않다.
		String[] lisences = req.getParameterValues("lisence");			
		for (String lisence : lisences) {
			System.out.println(lisence);
		}
	}
}
