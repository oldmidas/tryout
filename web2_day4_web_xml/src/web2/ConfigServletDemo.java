package web2;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServletDemo extends HttpServlet {
	String title;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// ServletContext ��ü ���
		ServletContext application = getServletContext();
		String name = application.getInitParameter("companyName");
		String mail = application.getInitParameter("admin");
		String path = application.getRealPath("web2");
		
		// ServletConfig ��ü ���
		ServletConfig config = getServletConfig();
		String title = config.getInitParameter("pageTitle");
		
		System.out.println("ȸ��� : " + name);
		System.out.println("�̸��� : " + mail);
		System.out.println("Ÿ��Ʋ : " + title);
		System.out.println("��   �� : " + path);
		
	}
	
	
	
}
