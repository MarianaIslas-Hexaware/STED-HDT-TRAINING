import java.sql.*;

public class MyTableUsingJava {

	public static void main (String[] args) throws Exception{
		createTable();
		post();
	}
	public static void post() throws Exception{
	
		try {
		Connection myConn = getConnection();
		PreparedStatement posted = myConn.prepareStatement("INSERT INTO datasheet1 (NAME, LASTNAME, EMAIL, PASSWORD, COMPANY, ADDRESS, CITY, ZIP_CODE, MOBILE_PHONE) VALUES ('Mariana', 'Vives', 'marianaV@hexaware.com','123456789','Hexaware', 'Mar Baltico 145', 'Zapopan', '45876','3345873429')");
		
		posted.executeUpdate();
		
	}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Insert completed");}
	}
		
		
	public static void createTable() throws Exception {
		try {
			Connection myConn = getConnection();
			PreparedStatement create = myConn.prepareStatement("CREATE TABLE IF NOT EXISTS datasheet1(NAME varchar(255), LASTNAME varchar(255), EMAIL varchar(255), PASSWORD varchar(255), COMPANY varchar(255), ADDRESS varchar(255), CITY varchar(255), ZIP_CODE varchar(255), MOBILE_PHONE varchar(255), PRIMARY KEY(NAME))");
			create.executeUpdate();
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			System.out.println("Function complete");
		}
	}
	
	private static Connection getConnection() throws Exception {
		try {
			
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String userName= "75178_user";
			String password="75178_user";
			
			
			Connection myConn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected successfuly");
			return myConn;
		}catch (Exception e) {
			System.out.println(e);
		}
			
		return null;
	
	}

}
