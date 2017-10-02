package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Department {
	
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	public Department() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/livsmedelskedja","root","");
		stmt = conn.createStatement();
	}
	
	public static GetsNSets printDepartment() throws SQLException{
		GetsNSets g = new GetsNSets();
		rs = stmt.executeQuery("SELECT * FROM department");
		
		while(rs.next()){
			g.setDep_name(rs.getString("dep_name"));
			g.setDep_id(rs.getInt("dep_id"));
			g.setLocation(rs.getString("location"));
			g.setSupervisor(rs.getString("supervisor"));
			g.setEmployee(rs.getInt("employee"));
			
			
			System.out.println("-----------------------------------------------");
			System.out.println("Department");
			System.out.print(" ID: " + g.getDep_id());
			System.out.print(", Department Name: " + g.getDep_name());
			System.out.print(", location: " + g.getLocation());
			System.out.println();
			System.out.print(" Supervisor: " + g.getSupervisor());
			System.out.print(", Employee: " + g.getEmployee());
			System.out.print(", Service: " + g.getService());
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
		}
		return g;
	}
	
	public void insertDepartment(GetsNSets getz) throws SQLException
	  {
		 Scanner scan = new Scanner(System.in);
		 String query = "INSERT INTO department ("
				    + " dep_name,"
				    + " location,"
				    + " employee,"
				    + " supervisor ) VALUES ("
				    + " ?, ?, ?,?)";

	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    System.out.println("Insert into department");
	    System.out.println("Select the name of the department: ");
	    getz.setDep_name(scan.nextLine());
	    System.out.println("Select the location of the department: ");
	    getz.setLocation(scan.nextLine());
	    System.out.println("Select the ID of the employee who works for this department: ");
	    getz.setEmployee(scan.nextInt());
	    System.out.println("Select the supervisor of the department: ");
	    getz.setSupervisor(scan.nextLine());
	    System.out.println("Finished with inserting into database.");
	    
	    st.setString(1, getz.getDep_name());
	    st.setString(2, getz.getLocation());
	    st.setString(3, getz.getSupervisor());
	    st.setInt(4, getz.getEmployee());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	 
	 public void updateDepartment(GetsNSets getz) throws SQLException
	  {
		 Scanner scan = new Scanner(System.in);
		 String query = "UPDATE department set dep_name=?, location=?, supervisor=?, employee=? where dep_id=?";

	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    
	    System.out.println("Update Department");
	    System.out.print("Select ID number: ");
	    getz.setEmployee_id(scan.nextInt());
	    scan.nextLine();
	    System.out.print("Select the name of the department: ");
	    getz.setDep_name(scan.nextLine());
	    System.out.print("Select the location of the department: ");
	    getz.setLocation(scan.nextLine());
	    System.out.print("Select the ID of the employee who works here: ");
	    getz.setEmployee(scan.nextInt());
	    System.out.print("Select the supervisor of the department: ");
	    getz.setSupervisor(scan.nextLine());
	    System.out.print("Finished with updating database.");
	    
	  
	    st.setString(1, getz.getDep_name());
	    st.setString(2, getz.getLocation());
	    st.setString(3, getz.getSupervisor());
	    st.setInt(4, getz.getDep_id());
	    st.setInt(5, getz.getEmployee());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	 
	 public void removeDepartment(GetsNSets getz) throws SQLException
	  {
		 Scanner scan = new Scanner(System.in);
		 String query = "delete from department where dep_id=?";

	    // set all the preparedstatement parameters
	    PreparedStatement st = conn.prepareStatement(query);
	    
	    System.out.println("Remove from department");
	    System.out.print("Select ID number of the row you want to remove: ");
	    getz.setDep_id(scan.nextInt());
	    System.out.print("Finished with removing.");
	    
	  
	    st.setInt(1, getz.getDep_id());

	    // execute the preparedstatement insert
	    st.executeUpdate();
	  }
	
}
