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
		//checkbox�� �Է°��� ������ ���� �������� �ʴ´�, �׷��Ƿ� if������ null�� ��Ȳ�� üũ�ؾ��Ѵ�.
		if (languages != null) {
			for (String lang : languages) {
				System.out.println(lang);
			}			
		}
		//text�� �Է°��� ��� �����̵ȴ�. checkboxó�� if���� �ʿ����� �ʴ�.
		String[] lisences = req.getParameterValues("lisence");			
		for (String lisence : lisences) {
			System.out.println(lisence);
		}
	}
}
