import java.sql.*;


public class JDBC_test {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn= null;
		Statement myStat=null;
		ResultSet myRe=null;
		
		try {
			//1. Get a connection to a database
			myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "75178_user", "75178_user");
			System.out.println("Database connection successful! \n");
			
			//2. create a statement
			myStat= myConn.createStatement();
			
			//3. Execute SQL query
			myRe= myStat.executeQuery("SELECT * FROM datasheet");
			
			//.4 Process the result set
			while (myRe.next()) {
				System.out.println(myRe.getString("NAME") + " " + myRe.getString("LASTNAME"));
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			if (myRe != null) {
				myRe.close();
			}
			
			if (myStat != null) {
				myStat.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
			
		}
	}
