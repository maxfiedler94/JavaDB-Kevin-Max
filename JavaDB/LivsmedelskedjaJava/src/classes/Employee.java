package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Employee {
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	public Employee() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/livsmedelskedja","root","");
		stmt = conn.createStatement();
	}
	
	public static GetsNSets printEmployee() throws SQLException {
		
		GetsNSets g = new GetsNSets();
		rs = stmt.executeQuery(" SELECT * FROM employee ");
		
	   while(rs.next()){
	    	g.setFirstname(rs.getString("firstname"));
	    	g.setLastname(rs.getString("lastname"));
	    	g.setGender(rs.getString("gender"));
	    	g.setEmployee_id(rs.getInt("employee_id"));
	    	g.setSalary(rs.getInt("salary"));
	    	g.setBdate(rs.getString("bdate"));
	    	
			System.out.println("-----------------------------------------------");
			System.out.println("Employee");
			System.out.print(" ID: " + g.getEmployee_id());
			System.out.print(", Firstname: " + g.getFirstname());
			System.out.print(", Lastname: " + g.getLastname());
			System.out.println();
			System.out.print(" Gender: " + g.getGender());
			System.out.print(", Salary: " + g.getSalary());
			System.out.print(", Birthdate: " + g.getBdate());
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
	    }
	   return g;
	}
	

	
	 public void insertEmployee(GetsNSets getz) throws SQLException
	  {
		 Scanner scan = new Scanner(System.in);
		 String query = "INSERT INTO employee ("
				    + " firstname,"
				    + " lastname,"
				    + " gender,"
				    + " salary,"
				    + " bdate ) VALUES ("
				    + " ?, ?, ?, ?, ?)";

	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    System.out.println("Insert");
	    System.out.println("Select the first name of the employee: ");
	    getz.setFirstname(scan.nextLine());
	    System.out.println("Select the last name of the employee: ");
	    getz.setLastname(scan.nextLine());
	    System.out.println("Select the gender of the employee: ");
	    getz.setGender(scan.nextLine());
	    System.out.println("Select the salary of the employee: ");
	    getz.setSalary(scan.nextInt());
	    System.out.println("Select the birthdate (xxxx-xx-xx) of the employee: ");
	    getz.setBdate(scan.next());
	    System.out.println("Finished with inserting into database.");
	    
	    st.setString(1, getz.getFirstname());
	    st.setString(2, getz.getLastname());
	    st.setString(3, getz.getGender());
	    st.setInt(4, getz.getSalary());
	    st.setString(5, getz.getBdate());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	 
	 public void updateEmployee(GetsNSets getz) throws SQLException
	  {
		 Scanner scan = new Scanner(System.in);
		 String query = "UPDATE employee set firstname=?, lastname=?, gender=?, salary=?, bdate=? where employee_id=?";

	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    
	    System.out.println("Update");
	    System.out.print("Select ID number: ");
	    getz.setEmployee_id(scan.nextInt());
	    scan.nextLine();
	    System.out.print("Select the first name of the employee: ");
	    getz.setFirstname(scan.nextLine());
	    System.out.print("Select the last name of the employee: ");
	    getz.setLastname(scan.nextLine());
	    System.out.print("Select the gender of the employee: ");
	    getz.setGender(scan.nextLine());
	    System.out.print("Select the salary of the employee: ");
	    getz.setSalary(scan.nextInt());
	    System.out.print("Select the birthdate (xxxx-xx-xx) of the employee: ");
	    getz.setBdate(scan.next());
	    System.out.print("Finished with inserting into database.");
	    
	  
	    st.setString(1, getz.getFirstname());
	    st.setString(2, getz.getLastname());
	    st.setString(3, getz.getGender());
	    st.setInt(4, getz.getSalary());
	    st.setString(5, getz.getBdate());
	    st.setInt(6, getz.getEmployee_id());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	 
	 public void removeEmployee(GetsNSets getz) throws SQLException
	  {
		Scanner scan = new Scanner(System.in);
		String query = "delete from employee where employee_id=?";

	    // set all the preparedstatement parameter
		PreparedStatement st = conn.prepareStatement(query);
	    System.out.println("Remove");
	    System.out.print("Select ID number of the row you want to remove: ");
	    getz.setEmployee_id(scan.nextInt());
	
	    System.out.print("Finished with removing.");
	    
	  
	    st.setInt(1, getz.getEmployee_id());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	 

}

