package upload;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.GalleryDAO;
import vo.GalleryVO;

// 멀티파트요청을 처리할 수 있는 서블릿으로 지정한다.
@MultipartConfig
@WebServlet(urlPatterns="/upload.hta")
public class UploadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//입력필드의 단순 텍스트 값 가져오기
		String username = req.getParameter("username");
		String description = req.getParameter("description");
		System.out.println("작성자 이름 : " + username);
		System.out.println("설명 : " + description);
		
		//첨부 파일이름 값 가져오기
		Part part = req.getPart("photofile");
		String fileName = getFileName(part);
		
		//실제 경로 알아내기
		ServletContext application = this.getServletContext();
		String galleryDir = application.getRealPath("gallery");
		System.out.println("갤러리 디렉토리경로:" + galleryDir);
		
		//첨부 파일 처리하기
		//첨부파일이 있는 경우
		if (fileName != null && !fileName.isEmpty()) {
			System.out.println("첨부파일명: " + fileName);
			
			// 파일을 갤러리에 저장하기
			part.write(galleryDir + "/" + fileName);
		}
		GalleryVO vo = new GalleryVO();
		vo.setUsername(username);
		vo.setDescription(description);
		vo.setFilename(fileName);
		
		GalleryDAO dao = new GalleryDAO();
		try {			
			dao.addGallery(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("gallery.jsp");
	}
	
	private String getFileName(Part part) {
		String fileName = null;
		String headerValue = part.getHeader("content-disposition");
		String[] elements = headerValue.split(";");
		for (String el : elements) {
			// filename으로 시작하는지 확인하기
			if (el.trim().startsWith("filename")) {
				fileName = el.substring(el.indexOf("=")+1).replace("\"", "");
			}
		}
		return fileName;
	}
}
