package classes;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("classes.Main");
		menu();
	}
	
		public static void menu() throws SQLException
		{
			int num;
			int num2;
			int num3;
			int num4;
			int num5;
			
			Employee e = new Employee ();
			GetsNSets g = new GetsNSets ();
			Department d = new Department();
			Services s = new Services();
			System.out.println();
			System.out.println("V�lj ett alternativ genom att ange alternativets siffra.");
			System.out.println("1. L�gg in v�rden i databasen.");
			System.out.println("2. Uppdatera databasen.");
			System.out.println("3. Radera v�rde i databasen.");
			System.out.println("4. Visa v�rden i databasen.");
			System.out.println();
			Scanner scan = new Scanner(System.in);
			num = scan.nextInt();
		
		
			if(num == 1)
			{
				System.out.println("V�lj vilken databas du vill l�gga till v�rden i.");
				System.out.println("1. Employee");
				System.out.println("2. Department");
				System.out.println("3. Service");
				Scanner scan2 = new Scanner(System.in);
				num2 = scan2.nextInt();
				
				if(num2 == 1)
				{
					e.insertEmployee(g);
					menu();
				}
				
				if(num2 == 2)
				{
					d.insertDepartment(g);
					menu();
				}
				
				if(num2 == 3)
				{
					s.insertServices(g);
					menu();
				}
			}
			
			if(num == 2)
			{
				System.out.println("V�lj vilken databas du vill uppdatera v�rden i.");
				System.out.println("1. Employee");
				System.out.println("2. Department");
				System.out.println("3. Service");
				Scanner scan3 = new Scanner(System.in);
				num3 = scan3.nextInt();
				
				if(num3 == 1)
				{
					e.updateEmployee(g);
					menu();
				}
				
				if(num3 == 2)
				{
					d.updateDepartment(g);
					menu();
				}
				
				if(num3 == 3)
				{
					s.updateServices(g);
					menu();
				}	
				
			}
			
			if(num == 3)
			{
				System.out.println("V�lj vilken databas du vill radera v�rden i.");
				System.out.println("1. Employee");
				System.out.println("2. Department");
				System.out.println("3. Service");
				Scanner scan4 = new Scanner(System.in);
				num4 = scan4.nextInt();
				
				if(num4 == 1)
				{
					e.removeEmployee(g);
					menu();
				}
				
				if(num4 == 2)
				{
					d.removeDepartment(g);
					menu();
				}
				
				if(num4 == 3)
				{
					s.removeServices(g);
					menu();
				}	
			}
			if(num == 4)
			{
				System.out.println("V�lj vilken databas du vill visa v�rden.");
				System.out.println("1. Employee");
				System.out.println("2. Department");
				System.out.println("3. Service");
				Scanner scan5 = new Scanner(System.in);
				num5 = scan5.nextInt();
				
				if(num5 == 1)
				{
					e.printEmployee();
					menu();
				}
				
				if(num5 == 2)
				{
					d.printDepartment();
					menu();
				}
				
				if(num5 == 3)
				{
					s.printServices();
					menu();
				}	
			}
		}
}