import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		EmpService e = new EmpService();
//		e.getInput();
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter 1 : add || 2 : view || 3 : update || 4 : delete || 5 : view all || 6 : import || 7 : export || 10 : exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					e.addNewEmp();
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					e.view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					e.update(x);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					e.delete(x);
					break;
				case 5:
					e.viewAll();
					break;
				case 6:
					e.importFromFile();
					break;
				case 7:
					e.exportToFile();
					break;
				case 10:
					System.out.println("Exiting...");
				default:
					System.out.println("Invalid entry please try again!!");
			}
			
			
		}while(choice!=10);
	}
	
	}




