package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		/*String name = request.getParameter("uname");
		String pass = request.getParameter("psw");
		PrintWriter pw = response.getWriter();
		if(name.equals("sreeja") && pass.equals("vaishu"))
		{
			pw.print("<b>Successful Login</b></br>");
			pw.print("<b>Hi</b> "+name+"</br>");
		}
		else
			pw.print("<b>UnSuccessful Login</b></br>");	*/
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String pass = request.getParameter("psw");
		PrintWriter pw = response.getWriter();
		boolean status=false;  
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        Connection con= DriverManager.getConnection(url, "system", "vaishu");
	        Statement stmt = con.createStatement();
		    ResultSet rs= stmt.executeQuery("select * from student where Hno='"+name+"'and password='"+pass+"'");
		    status=rs.next();
		    if(status)
		    {
		    	pw.println("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><style>button {\r\n" + 
		    			"  background-color: #2E9ABC;\r\n" + 
		    			"  color: white;\r\n" + 
		    			"  padding: 14px 20px;\r\n" + 
		    			"  margin: 8px 0;\r\n" + 
		    			"  border: none;\r\n" + 
		    			"  cursor: pointer;\r\n" + 
		    			"  width: 100%;\r\n" + 
		    			"}"
		    			+ "body {font-family: Arial, Helvetica, sans-serif;}"
		    			+ ".mybtn  {\r\n" + 
		    			"   -weight: bold;\r\n" + 
		    			"}</style>\r\n" + 
		    			"</head><body><h1>STUDENT DETAILS</h1><br><br><b>HallTicket-Number:</b>"+rs.getString(1)+"<br><br><b>Name :</b>"+rs.getString(2)+"<br><br><b>YEAR :</b>"+rs.getInt(4)+"<br><br>"+"<b>SEMESTER :</b>"+rs.getInt(5)+"<br><br>"+"<b>BRANCH :</b>"+rs.getString(6)+"<br><br><br><form action="+"Feeservlet"+" "+"method="+"post"+"><button type="+"submit"+" "+"class="+"button"+">CHECK FEE DETAILS</button></form></body></html>");
		    	
		    	//pw.println("successful login");
		    	//RequestDispatcher  rd=request.getRequestDispatcher("FormPage.html");
		    	//rd.forward(request, response);
		    	//response.sendRedirect("html/FormPage.html");
		    }
		    else
		    	pw.println("unsuccessful login...try again");
		}
		catch(Exception e)
		{
			pw.print(e);	
		}
	
	}

}
