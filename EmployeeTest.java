package Demo;
import java.util.Scanner;
public class EmployeeTest {

	public static void main(String[] args) {
		//Scanner is used to take input from Scanner class
		Scanner sc=new Scanner(System.in);
		//Create Employee object
		Employee employee=new Employee();
		//Create Attendance object
		Attendance attendance=new Attendance();
		//Create Salary object
		Salary salary=new Salary();
		//	Variable for menu choice
		int choice;
		//do-while is used because the menu must appear at least once
	    do {
	    	System.out.println("\n====================================================================");
	    	System.out.println("                EMPLOYEE ATTENDENCE & PAYROLL SYATEM");
	    	System.out.println("\n====================================================================");
	    	System.out.println("1. Enter Employee Details");
	    	System.out.println("2. Calculate Attendance");
	    	System.out.println("3. Enter Employee Salary");
	    	System.out.println("4. Display Employee Details");
	    	System.out.println("5. Exit");
	    	System.out.println("Enter your choice: ");
	    	choice = sc.nextInt();
	    	//switch is used for the fixed menu choices
	    	switch(choice) {
	    	//====================================================================
	    	//                 EMPLOYEE ATTENDENCE & PAYROLL SYATEM
	    	//====================================================================
	    	case 1:
	    		System.out.println("EMPLOYEE ATTENDENCE & PAYROLL SYATEM");
	    		//Read Employee
	    		System.out.println("Enter Employee ID: ");
	    		employee.employeeId=sc.nextInt();
	    		//Clear the extra newline
	    		sc.nextLine();
	    		//Read employee name
	    		System.out.println("Enter Employee Name: ");
	    		employee.employeeName=sc.nextLine();
	    		//Department selection
	    		System.out.println("\nSelect Department:");
	    		System.out.println("1. IT");
	    		System.out.println("2. HR");
	    		System.out.println("3. Finance");
	    		System.out.println("4. Marketing");
	    		System.out.println("Enter Department Choice: ");
	    		employee.departmentChoice=sc.nextInt();
	    		//switch is used for department selection
	    		switch(employee.departmentChoice) {
	    		case 1:
	    			employee.department="IT";
	    			break;
	    	    case 2:
	    	    	employee.department="HR";
	    		    break;
	            case 3:
	            	employee.department="Finance";
		            break;
	            case 4:
	            	employee.department="Marketing";
	            	break;
	            default:
	            	employee.department="Unknown";
		            System.out.println("Invalid department choice.");
		            }
	    		//Read basic salary
	    		System.out.println("Enter Basic Salary: ");
	    		employee.basicSalary=sc.nextDouble();
	    		//if-else checks whether salary is valid
	    		if(employee.basicSalary>0) {
	    			System.out.println("Employee details entered successfully");
	    		}else {
	    			System.out.println("Invalid salary. Salary must be greater than zero.");
	    		}
	    		break;
		    	//====================================================================
		    	//                 EMPLOYEE ATTENDENCE CALCULATION
		    	//====================================================================
	    	case 2:
	    		System.out.println("\n---ATTENDENCE CALCULATION---");
	    		System.out.println("Enter Total Working Days: ");
	    		attendance.totalWorkingDays=sc.nextInt();
	    		//Check whether working days are valid
	    		
	    		if(attendance.totalWorkingDays>0) {
	    			//Initially present and absent days are zero
	    			attendance.presentDays=0;
	    			attendance.absentDays=0;
	    			/* for loop is used to know no.of working days*/
	    			for(int day=1; day<=attendance.totalWorkingDays;day++) {
	    				System.out.println("Day "+day+" - Enter 1 for present,0 for absent");
	    				attendance.attendance=sc.nextInt();
	    				if(attendance.attendance==1) {
	    					attendance.presentDays++;
	    				}else if(attendance.attendance==0) {
	    					attendance.absentDays++;
	    				}else {
	    					System.out.println("Invalid input. Enter only 1 or 0.");
	    				}
	    			}
	    			//Calculate Attendance percentage
	    	    	attendance.attendancePercentage = ((double) attendance.presentDays/attendance.totalWorkingDays)*100;
	    	    	System.out.println("\nPresent Days:" +attendance.presentDays);
	    	    	System.out.println("Absent Days:" +attendance.absentDays);
	    	    	System.out.println("Attendance % :" +attendance.attendancePercentage +"%");
	    	    	//Check attendance eligibility
	    	    	if(attendance.attendancePercentage>=75) {
	    	    		System.out.println("Attendance Status: Eligible");
	    	    	}else {
	    	    		System.out.println("Attendance Status: Not Eligible");
	    	    	}
	    		}else {
	    			System.out.println("Working days must be greater than zero.");
	    		}
	    		break;
		    	//====================================================================
		    	//                 CASE 3:CALCULATE SALARY
		    	//====================================================================
	    	case 3:
	    		System.out.println("\n---SALARY CALCULATION---");
	    		//First check whether valid employee salary has been entered.
	    		if(employee.basicSalary>0) {
	    			if(attendance.totalWorkingDays>0) {
	    				if(attendance.attendancePercentage>=90) {
	    					//10% incentive
	    				    salary.incentive=employee.basicSalary*0.10;
	    				    salary.finalSalary=employee.basicSalary+salary.incentive;
	    				    System.out.println("Attendance Category:Excellent");
	    				    System.out.println("Attendance Incentive:100%");
	    				}
	    				else if(attendance.attendancePercentage>=75) {
	    				//No incentive and no deduction
	    				salary.incentive=0;
	    				salary.deduction=0;
	    				salary.finalSalary=employee.basicSalary;
	    				System.out.println("Attendance Category: Good");
	    				System.out.println("Attendance Incentive: 0%");
	    				}else {
	    				//10% deduction
	    				salary.deduction=employee.basicSalary*0.10;
	    				salary.finalSalary=employee.basicSalary-salary.deduction;
	    				System.out.println("Attendance Deduction: 100%");
	    				}
	    				System.out.println("Basic Salary : Rs"+ employee.basicSalary);
	    				System.out.println("Final Salary : Rs"+ salary.finalSalary);
	    		}else {
	    			System.out.println("Please calculate attendance first.");
	    			}
	    		}else {
	    			System.out.println("Please enter valid employee details first.");
	    			}
	    		 break;
			    	//====================================================================
			    	//                 CASE 3:CALCULATE SALARY
			    	//====================================================================
	    		 case 4:
	    			 System.out.println("\n---EMPLOYEE DETAILS---");
	    			 //Check whether employee info has been entered
	    			 if(employee.employeeId!=0) {
	    				 System.out.println("Employee ID    :"+employee.employeeId);
	    				 System.out.println("Employee Name  :"+employee.employeeName);
	    				 System.out.println("Department     :"+employee.department);
	    				 System.out.println("Basic Salary   :"+employee.basicSalary);
	    				 System.out.println("Present Days   :"+attendance.presentDays);
	    				 System.out.println("Absent Days    :"+attendance.absentDays);
	    				 System.out.println("Attendance %   :"+attendance.attendancePercentage + "%");
	    				 System.out.println("Final Salary    :"+salary.finalSalary);
	    			 }else {
	    				 System.out.println("No employee details available.");
	    			 }
	    			 break;
	    			//====================================================================
				    //                 CASE 5:EXIT
				   	//====================================================================
	    	case 5:
	    		System.out.println("\nThank you for using the system.");
	    		break;
	    	default:
	    		System.out.println("Invalid menu choice. Please enter 1 to 5.");
	    }
	    }while(choice!=5);
	    //Close Scanner
	    sc.close();
	}

}