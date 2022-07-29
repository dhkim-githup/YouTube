
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PeopleService;
import service.RegistService;
import vo.People;

/**
 * Servlet implementation class RegistPeople
 */
@WebServlet("/RegistPeople")
public class RegistPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* ID , Name, Age �� �޴� �κ� */
		request.setCharacterEncoding("UTF-8");
    	
	    String strID 	= request.getParameter("input_id");
	    String strName 	= request.getParameter("input_name");
	    String strAge	= request.getParameter("input_age");
		
		/* �ش� ���ڰ��� ������ Insert ��Ű�� �޼��� Call */
	    RegistService registservice = new RegistService();
	    int intResult = registservice.doInsert(strID, strName, strAge);
	    
		/* �۾��� ���� �� ������ ��ġ ���� */
		List<People> list = new ArrayList<>();
	    
	    PeopleService peopleService = new PeopleService();
		
		list = peopleService.doSelect();
		// ����Ʈ�� ���� Attribute �� ���� �ְ� �޴´�.
		request.setAttribute("people", list);
		
		/* forward ��� 
		 * List �� ���� Attribute �� ���� �����Ѵ�. 
		 * */		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
		 dispatcher.forward(request, response);
		 		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}