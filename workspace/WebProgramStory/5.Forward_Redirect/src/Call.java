

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Call
 */
@WebServlet("/Call")
public class Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Call() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strName = request.getParameter("No");	
		
		String strPath="";
		
		/* ==================== forward =================================== */
		if("1".equals(strName)){
			strPath 	= "/WEB-INF/view/list.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(strPath);		
			dispatcher.forward(request, response);
			
		}else if("2".equals(strName)){
			strPath 	= "/jsp/list.jsp";			
			RequestDispatcher dispatcher = request.getRequestDispatcher(strPath);		
			dispatcher.forward(request, response);
		
		}else if("3".equals(strName)){
			strPath 	= "https://www.google.com";			
			RequestDispatcher dispatcher = request.getRequestDispatcher(strPath);		
			dispatcher.forward(request, response);	
			
		/* ==================== sendRedirect =================================== */	
		}else if("4".equals(strName)){
			strPath 	= "/Forward_Redirect/WEB-INF/view/list.jsp";				
			response.sendRedirect(strPath);
			
		}else if("5".equals(strName)){
			strPath 	= "/Forward_Redirect/jsp/list.jsp";
			response.sendRedirect(strPath);
			
		}else if("6".equals(strName)){
			strPath 	= "https://www.google.com";	
			response.sendRedirect(strPath);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
