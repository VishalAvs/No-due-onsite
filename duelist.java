package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Duelist
 */
@WebServlet("/Duelist")
public class Duelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Duelist() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		//String name = request.getParameter("uname");
		//String pass = request.getParameter("psw");
		PrintWriter pw = response.getWriter();
		boolean status=false;  
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        Connection con= DriverManager.getConnection(url, "system", "vaishu");
	        Statement stmt = con.createStatement();
		    ResultSet rs= stmt.executeQuery("select * from student");
		    
		    while(rs.next())
		    {
		    	pw.println("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
		    			"<style>\r\n" + 
		    			"body {font-family: Arial, Helvetica, sans-serif;}\r\n" + 
		    			"form {border: 3px solid #f1f1f1;}\r\n" + 
		    			"\r\n" + 
		    			"input[type=text], input[type=password] {\r\n" + 
		    			"  width: 100%;\r\n" + 
		    			"  padding: 12px 20px;\r\n" + 
		    			"  margin: 8px 0;\r\n" + 
		    			"  display: inline-block;\r\n" + 
		    			"  border: 1px solid #ccc;\r\n" + 
		    			"  box-sizing: border-box;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			"button {\r\n" + 
		    			"  background-color: #2E9ABC;\r\n" + 
		    			"  color: white;\r\n" + 
		    			"  padding: 14px 20px;\r\n" + 
		    			"  margin: 8px 0;\r\n" + 
		    			"  border: none;\r\n" + 
		    			"  cursor: pointer;\r\n" + 
		    			"  width: 100%;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			"button:hover {\r\n" + 
		    			"  opacity: 0.8;\r\n" + 
		    			"  font-weight: bold;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			".cancelbtn {\r\n" + 
		    			"  width: auto;\r\n" + 
		    			"  padding: 10px 18px;\r\n" + 
		    			"  font-weight: bold;\r\n" + 
		    			"  background-color: #B1D52B;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			".imgcontainer {\r\n" + 
		    			"  text-align: center;\r\n" + 
		    			"  margin: 24px 0 12px 0;\r\n" + 
		    			"}\r\n" + 
		    			".mybtn  {\r\n" + 
		    			"  font-weight: bold;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			"img.avatar {\r\n" + 
		    			"  width: 40%;\r\n" + 
		    			"  border-radius: 50%;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			".container {\r\n" + 
		    			"  padding: 16px;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			"span.psw {\r\n" + 
		    			"  float: right;\r\n" + 
		    			"  padding-top: 16px;\r\n" + 
		    			"}\r\n" + 
		    			"\r\n" + 
		    			"/* Change styles for span and cancel button on extra small screens */\r\n" + 
		    			"@media screen and (max-width: 300px) {\r\n" + 
		    			"  span.psw {\r\n" + 
		    			"     display: block;\r\n" + 
		    			"     float: none;\r\n" + 
		    			"  }\r\n" + 
		    			"  .cancelbtn {\r\n" + 
		    			"     width: 100%;\r\n" + 
		    			"  }\r\n" + 
		    			"}\r\n" + 
		    			"</style>\r\n" + 
		    			"</head><body><form action="+"Alumniapprove"+" "+"method="+"post"+"><div class=\"container\"><button class="+"cancelbtn"+" type="+"submit"+"name="+"rollbutton"+" value="+"rs.getString(1)"+">"+rs.getString(1)+"</button></div></form></body></html>");
		    }
		   // status=rs.next();
		   /* if(status)
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
		    	pw.println("unsuccessful login...try again");*/
		}
		catch(Exception e)
		{
			pw.print(e);	
		}
	
	}

}
