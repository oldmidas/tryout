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

// ��Ƽ��Ʈ��û�� ó���� �� �ִ� �������� �����Ѵ�.
@MultipartConfig
@WebServlet(urlPatterns="/upload.hta")
public class UploadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//�Է��ʵ��� �ܼ� �ؽ�Ʈ �� ��������
		String username = req.getParameter("username");
		String description = req.getParameter("description");
		System.out.println("�ۼ��� �̸� : " + username);
		System.out.println("���� : " + description);
		
		//÷�� �����̸� �� ��������
		Part part = req.getPart("photofile");
		String fileName = getFileName(part);
		
		//���� ��� �˾Ƴ���
		ServletContext application = this.getServletContext();
		String galleryDir = application.getRealPath("gallery");
		System.out.println("������ ���丮���:" + galleryDir);
		
		//÷�� ���� ó���ϱ�
		//÷�������� �ִ� ���
		if (fileName != null && !fileName.isEmpty()) {
			System.out.println("÷�����ϸ�: " + fileName);
			
			// ������ �������� �����ϱ�
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
			// filename���� �����ϴ��� Ȯ���ϱ�
			if (el.trim().startsWith("filename")) {
				fileName = el.substring(el.indexOf("=")+1).replace("\"", "");
			}
		}
		return fileName;
	}
}
