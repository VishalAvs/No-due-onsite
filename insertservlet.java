package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insertservlet
 */
@WebServlet("/Insertservlet")
public class Insertservlet extends HttpServlet {
	
	String b;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertservlet() {
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
		b = request.getParameter("rollbutton");
		//String pass = request.getParameter("psw");
		PrintWriter pw = response.getWriter();
		boolean status=false;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        Connection con= DriverManager.getConnection(url, "system", "vaishu");
	        Statement stmt = con.createStatement();
		   // ResultSet rs= stmt.executeQuery("select c.fee,c.specialfee,b.cleared,l.bookfee,lab.due from college c,bank b,library l,labs lab where c.Hno=b.Hno and b.Hno=l.Hno and l.Hno=lab.Hno;");
	       // ResultSet rs= stmt.executeQuery("select c.Hno,c.fee,c.specialfee,b.cleared,lib.bookfee,l.due from college c,bank b,library lib,labs l where c.Hno=l.Hno and c.Hno=);
	      // ResultSet rs= stmt.executeQuery("select distinct(c.Hno),c.fee,c.specialfee,b.cleared,lib.bookfee,l.due from college c,bank b,library lib,labs l where c.Hno=l.Hno");
	       // pw.println("haiiiiii"+b);
	        ResultSet rs= stmt.executeQuery("select * from student");
	        status=rs.next();
	        b=rs.getString(1);
	    	//pw.println("heyyyyyy    "+b);
	        
	       // rs= stmt.executeQuery("select distinct(c.Hno),c.fee,c.specialfee,b.cleared,lib.bookfee,l.due from college c,bank b,library lib,labs l where c.Hno=l.Hno and c.Hno="+b+"");
	        rs= stmt.executeQuery("update approve set alumni="+"'Signed'"+" where Hno='"+b+"'");
	        rs.next();
	        if(status)
		    {
		    	
		    	
		    	//pw.println("<html><body><h1>FEE DETAILS</h1><br><br><b>COLLEGE FEE :</b>"+rs.getString(1)+"<br><b>SPECIAL FEE :</b>"+rs.getString(2)+"<br><b>AMOUNT CLEARED :</b>"+rs.getString(3)+"<br><b>BOOK FEE :</b>"+rs.getString(4)+"<br><b>DUE :</b>"+rs.getString(5)+"<br></body></html>");
		    	/*pw.println("<html><head>\r\n" + 
		    			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
		    			"<style>\r\n" + 
		    			"body {font-family: Arial, Helvetica, sans-serif;}button {\r\n" + 
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
		    			".mybtn  {\r\n" + 
		    			"  font-weight: bold;\r\n" + 
		    			"}\r\n" + 
		    			"</style>\r\n" + 
		    		
		    		"</head><body><h1>FEE DETAILS :</h1><br><br><b>HALL TICKET NUMBER :</b>"+rs.getString(1)+"<br><br><b>COLLEGE FEE:</b> "+rs.getString(2)+"<br><br><b>SPECIAL FEE</b>"+rs.getString(3)+"<br><br><b>AMOUNT CLEARED :</b>"+rs.getString(4)+"<br><br><b>BOOK FEE :</b>"+rs.getString(5)+"<br><br><b>LABS FEE DUE :</b>"+rs.getString(6)+"<br><br><br><form action="+"Approved.html"+" "+"method="+"post"+"><button type="+"submit"+" "+"class="+"button"+">APPROVE</button><br><br></form><br><br></body></html>");
		    */
		    	//pw.println("<html><body><h1>FEE DETAILS : </h1><br><br><br></body></html>");
		    	
		    	//pw.println("successful login"+rs.getString(2));
		    	RequestDispatcher  rd=request.getRequestDispatcher("Approved.html");
		    	rd.forward(request, response);
		    	//response.sendRedirect("html/FormPage.html");
	        	//response.sendRedirect("html/Approved.html");
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
