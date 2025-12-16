package jdbcdemo.org;
import java.sql.*;
public class demo {

	/*
	 * seven steps
	 * 1.Import the package
	 * 2.Load and register the driver
	 * 3.establish a connection
	 * 4.create a statement (statemeny,preparedstatement,callablestatement)
	 * 5.execute the statement
	 * 6.process the result
	 * 7.close the connection
	 */
	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		 //Class.forName("com.mysql.cj.jdbc.Driver");
		
		 String url="jdbc:mysql://localhost:3306/demo";
		 String user="root";
		 String password="250408";
		Connection con = DriverManager.getConnection(url, user, password);
		
		int cid=2;
		String cname="java";
		String sql="insert into course value(?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,cid);
		st.setString(2, cname);
				
		int val=st.executeUpdate();
		
		con.close();
	}
}
