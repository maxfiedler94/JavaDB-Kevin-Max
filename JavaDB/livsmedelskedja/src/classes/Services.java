package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Services {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public Services() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/livsmedelskedja","root","");
        stmt = conn.createStatement();
    }
    
    public static GetsNSets printServices() throws SQLException {
    	
		GetsNSets g = new GetsNSets();
		rs = stmt.executeQuery("SELECT * FROM department");
		
		while(rs.next()){
			g.setService_name(rs.getString("service_name"));
			g.setService_id(rs.getInt("service_id"));
			g.setEmployee(rs.getInt("employee"));
			g.setDepartment(rs.getInt("department"));
			
			System.out.println("-----------------------------------------------");
			System.out.println("Services");
			System.out.print(" ID: " + g.getService_id());
			System.out.print(", Service Name: " + g.getService_name());
			System.out.println();
			System.out.print(" Department: " + g.getDepartment());
			System.out.print(", Employee: " + g.getEmployee());
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
		}
		return g;
    }
    public void insertServices(GetsNSets getz) throws SQLException
      {
         Scanner scan = new Scanner(System.in);
         String query = "INSERT INTO services ("
                    + " service_name,"
                    + " employee,"
                    + " department," + "VALUES ("
                    + " ?, ?, ? )";
        // set all the preparedstatement parameters
        PreparedStatement st = conn.prepareStatement(query);
        System.out.println("Insert into services");
        System.out.println("Select the name of the service: ");
        getz.setService_name(scan.nextLine());
        System.out.println("Select the department of the service");
        getz.setDepartment(scan.nextInt());
        System.out.println("Select the ID of the employee who works at this service");
        getz.setEmployee(scan.nextInt());
        System.out.println("Finished with inserting into database.");
        
        st.setString(1, getz.getService_name());
        st.setInt(2, getz.getDepartment());
        st.setInt(3, getz.getEmployee());
        // execute the preparedstatement insert
        st.executeUpdate();
      }
     
     public void updateServices(GetsNSets getz) throws SQLException
      {
         Scanner scan = new Scanner(System.in);
         String query = "UPDATE service set service_name=?, department=?, employee=? where serice_id=?";
        // set all the preparedstatement parameters
        PreparedStatement st = conn.prepareStatement(query);
        
        System.out.println("Update services");
        System.out.print("Select ID number: ");
        getz.setEmployee_id(scan.nextInt());
        scan.nextLine();
        System.out.print("Select the name of the service: ");
        getz.setService_name(scan.nextLine());
        System.out.print("Select the department of the service");
        getz.setDepartment(scan.nextInt());
        System.out.print("Select the ID of the employee that works here");
        getz.setEmployee(scan.nextInt());
        System.out.print("Finished with updating database.");
        
      
        st.setString(1, getz.getService_name());
        st.setInt(2, getz.getDepartment());
        st.setInt(3, getz.getService_id());
        st.setInt(4, getz.getEmployee());
        // execute the preparedstatement insert
        st.executeUpdate();
      }
     
     public void removeServices(GetsNSets getz) throws SQLException
      {
         Scanner scan = new Scanner(System.in);
         String query = "delete from services where service_id=?";
        // set all the preparedstatement parameters
        PreparedStatement st = conn.prepareStatement(query);
        
        System.out.println("Remove from services");
        System.out.print("Select ID number of the row you want to remove: ");
        getz.setService_id(scan.nextInt());
        System.out.print("Finished with removing.");
        
      
        st.setInt(1, getz.getService_id());
        // execute the preparedstatement insert
        st.executeUpdate();
      }
    
}
