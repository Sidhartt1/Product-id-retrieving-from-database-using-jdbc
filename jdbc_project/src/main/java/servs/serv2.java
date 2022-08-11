package servs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class serv2
 */
@WebServlet("/search")
public class serv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out = res.getWriter();
		product p = new product();
		try {
			Connection con = DbUtil.getCon();
			Statement st = con.createStatement();
			String sql = "select * from product";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getInt(1)==Integer.parseInt(req.getParameter("id")))
				{
					out.println("Your product ID: "+rs.getInt(1)+" \nYour Product Name: "+rs.getString(2)+" \nYour Product expiry date: "+rs.getString(3));
				}	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch blockace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
