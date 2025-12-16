package jdbcdemo.org;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class Bank {

	public static void main (String args[]) throws SQLException, FileNotFoundException, IOException {
		
		String csvfile="C:\\Users\\bhara\\Downloads\\bank details.txt";
		String url="jdbc:mysql://localhost:3306/bankdb";
		String user="root";
		String password="250408";
		String sql="Insert into bank_details values(?,?,?,?,?)";
		
		BufferedReader rd =new BufferedReader(new FileReader(csvfile));
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement st =con.prepareStatement(sql);
		
		String line;
		rd.readLine();
		while((line =rd.readLine())!=null) {
			
			String[] data =line.split(",");
			String txn_id=data[0];
			long accountno=Long.parseLong(data[1]);
			String txn_type= data[2];
			int amount=Integer.parseInt(data[3]);
			String date =data[4];
			
			if(amount<=0) {
				System.out.println("Amount should be greater than zero" +txn_id);
				continue;
			}
			if(!txn_type.equals("DEBIT") && !txn_type.equals("CREDIT")) {
				System.out.println("INVALID TYPE OF TRANSACTION" + txn_id);
				continue;
			}
			
			st.setString(1, txn_id);
			st.setLong(2, accountno);
			st.setString(3, txn_type);
			st.setInt(4, amount);
			st.setString(5, date);
			
			
			st.executeUpdate();
		}
		
		System.out.println("CSV file uploaded successfully");
	}
	
	
	
	
}
