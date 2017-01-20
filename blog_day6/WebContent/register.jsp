<%@page import="dao.BlogDAO"%>
<%@page import="vo.BlogVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	request.setCharacterEncoding("utf-8");

	// 새글인지 댓글인지 알려주는 값
	String type = request.getParameter("type");
	
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	BlogVO blog = new BlogVO();
	blog.setTitle(title);
	blog.setWriter(writer);
	blog.setContents(contents);
	
	BlogDAO dao = new BlogDAO();
	if ("new".equals(type)) {
		// 새글인 경우
		int seq = dao.getSeq();
		blog.setNo(seq);
		blog.setGroupno(seq);
		dao.addBlog(blog);
	} else if ("re".equals(type)) {
		// 댓글인 경우
		int seq = dao.getSeq();
		blog.setNo(seq);
		int gno = Integer.parseInt(request.getParameter("gno"));
		blog.setGroupno(gno);
		dao.addBlog(blog);		
	}
	
	response.sendRedirect("list.jsp");
%>