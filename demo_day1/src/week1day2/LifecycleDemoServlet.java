package week1day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/life"})
public class LifecycleDemoServlet extends HttpServlet{	
	public LifecycleDemoServlet() {
		System.out.println("LifecycleDemoServlet constructor is running ...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() is running ...");
	}
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(req, resp) is running ...");
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("Hello!!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() is running ...");
	}
}
