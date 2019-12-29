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

@WebServlet("/book/list")
public class BookDataListServlet extends HttpServlet {
	
	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{		
		try {
			ServletContext sc = this.getServletContext();
			
			BookDataDao bookDataDao = (BookDataDao)sc.getAttribute("bookDataDao");
			
			request.setAttribute("bookDataList", bookDataDao.selectList());
			
			response.setContentType("text/html; charset=UTF-8");
			
			// JSP 출력 위임
			RequestDispatcher rd = request.getRequestDispatcher("/bookData/BookDataList.jsp");
			rd.include(request, response);
			
		} catch (Exception e) {
			// throw new ServletException(e);
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
			ServletContext sc = this.getServletContext();
			
			BookDataDao bookDataDao = (BookDataDao)sc.getAttribute("bookDataDao");
			
			BookData bookData = new BookData()
									.setEmail(request.getParameter("email"))
									.setPassword(request.getParameter("password"))
									.setText(request.getParameter("g_text"));
			bookDataDao.insert(bookData);
			
			RequestDispatcher rd = request.getRequestDispatcher("/auth/Success.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// throw new ServletException(e);
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			
		} finally {
			
		}
	}
}
