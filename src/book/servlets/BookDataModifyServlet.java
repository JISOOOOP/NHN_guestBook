package book.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.BookDataDao;
import book.vo.BookData;

@WebServlet("/book/modify")
public class BookDataModifyServlet extends HttpServlet{
	
	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			ServletContext sc = request.getServletContext();
			
			BookDataDao bookDataDao = (BookDataDao)sc.getAttribute("bookDataDao");
			BookData bookData = bookDataDao.selectOne(Integer.parseInt(request.getParameter("no")));
			request.setAttribute("bookData", bookData);
			
			response.setContentType("text/html; charset=utf-8");
			RequestDispatcher rd = request.getRequestDispatcher("/bookData/BookDataModify.jsp");
			rd.include(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			
		} finally {
			
		}
	}
	
	@Override
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			ServletContext sc = request.getServletContext();
			
			BookDataDao bookDataDao = (BookDataDao)sc.getAttribute("bookDataDao");
			
			// Password check
			BookData bookData = bookDataDao.exist(request.getParameter("email"), request.getParameter("password"));
			bookData.setText(request.getParameter("text"));
			if(bookData != null) {
				bookDataDao.update(bookData);
			} else {
				throw new Exception("비밀번호가 맞지 않습니다.");
			}
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		} finally {
			
		}
	}

}
