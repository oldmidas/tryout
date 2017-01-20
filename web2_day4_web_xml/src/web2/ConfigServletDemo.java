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
		// ServletContext 객체 얻기
		ServletContext application = getServletContext();
		String name = application.getInitParameter("companyName");
		String mail = application.getInitParameter("admin");
		String path = application.getRealPath("web2");
		
		// ServletConfig 객체 얻기
		ServletConfig config = getServletConfig();
		String title = config.getInitParameter("pageTitle");
		
		System.out.println("회사명 : " + name);
		System.out.println("이메일 : " + mail);
		System.out.println("타이틀 : " + title);
		System.out.println("경   로 : " + path);
		
	}
	
	
	
}
