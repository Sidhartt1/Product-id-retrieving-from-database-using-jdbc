package servs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

public class productDAO extends HttpServlet
{
	public int insert(product p) throws ClassNotFoundException, SQLException
	{
		Connection con = DbUtil.getCon();
		if(con!=null)
		{
			System.out.println("estblished");
		}
		Statement st = con.createStatement();
		String sql = "insert into product values("+p.getPid()+",'"+p.getPname()+"','"+p.getPdate()+"')";
		int row = st.executeUpdate(sql);
		return row;
	}

	
}
