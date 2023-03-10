package main;

import java.util.Scanner;

import custom.ConsoleColors;
import exception.ComplaintException;
import useCases.AssignTheComplaintToTheEngineerUseCase;
import useCases.ChangeYourPasswordEmployeeUseCase;
import useCases.ChangeYourPasswordEngineerUseCase;
import useCases.EmployeeLoginUseCase;
import useCases.EmployeeRegistrationUseCase;
import useCases.EngineerLoginUseCase;
import useCases.GetAllAssignedComplaintsByHodUseCase;
import useCases.GetHistoryOfAllComplaintsUseCase;
import useCases.GetListOfAllComplaintsUseCase;
import useCases.GetListOfAllEngineersUseCase;
import useCases.GetListOfAttendedComplaintsUseCase;
import useCases.GetStatusOfYourComplaintUseCase;
import useCases.HodLoginUseCase;
import useCases.RegisterAComplaintUseCase;
import useCases.RegisterANewEngineerUseCase;
import useCases.RemoveAnEngineerFromSystemUseCase;
import useCases.UpdateTheStatusOfComplaintUseCase;

public class Main {
	public static void main(String[] args) {
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Welcome To Online Hardware And Software Support System"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"------------------------------------------------------"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE + "+------------------+" + "\n"
				+ "| 1. HOD           |" + "\n"
				+ "| 2. Engineer      |" + "\n"
				+ "| 3. Employee      |" + "\n"
				+ "| 4. Exit          |" + "\n"
				+ "+------------------+" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"Please choose a number from above options"+ ConsoleColors.RESET);
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch(choice) {

		case 1:
			System.out.println();
			System.out.println(ConsoleColors.ROSY_PINK + "Welcome HOD! Please Login to your account." + ConsoleColors.RESET);
			HodLoginUseCase hodLogin = new HodLoginUseCase();
			hodLogin.loginHod();
			while(true) {
				System.out.println(ConsoleColors.PURPLE + "+---------------------------------------+" + "\n"
						+ "| 1. Register An Engineer.              |" + "\n"
						+ "| 2. Get List Of Engineers.             |" + "\n"
						+ "| 3. Remove An Engineer From System.    |" + "\n"
						+ "| 4. Get The List Of complaints.        |" + "\n"
						+ "| 5. Assign a Complaint To An Engineer. |" + "\n"
						+ "| 6. Logout                             |" + "\n"
						+ "+---------------------------------------+" + ConsoleColors.RESET);

				int choose=sc.nextInt();

				if(choose == 1) {
					System.out.println();
					RegisterANewEngineerUseCase register = new RegisterANewEngineerUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Enter The Credentials Of Engineer."+ConsoleColors.RESET);
					register.engineerRegistrationByHod();
				}

				else if(choose == 2) {
					System.out.println();
					GetListOfAllEngineersUseCase getEng = new GetListOfAllEngineersUseCase();
					System.out.println(ConsoleColors.GREEN_BACKGROUND+"List Of Engineers"+ConsoleColors.RESET);
					getEng.listOfEngineers();
				}				

				else if(choose == 3) {
					System.out.println();
					RemoveAnEngineerFromSystemUseCase removeEng = new RemoveAnEngineerFromSystemUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Enter ID To Remove The Engineer."+ConsoleColors.RESET);
					removeEng.engineerRemove();
				}

				else if(choose == 4) {
					System.out.println();
					GetListOfAllComplaintsUseCase getComplaints = new GetListOfAllComplaintsUseCase();
					System.out.println(ConsoleColors.GREEN_BACKGROUND+"List Of Complaints"+ConsoleColors.RESET);
					getComplaints.listOfComplaints();
				}

				else if(choose == 5) {
					System.out.println();
					AssignTheComplaintToTheEngineerUseCase assignEng = new AssignTheComplaintToTheEngineerUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Assign a Complaint To An Engineer"+ConsoleColors.RESET);
					assignEng.assignComplaint();
				}

				else if(choose == 6) {
					System.out.println();
					System.out.println(ConsoleColors.YELLOW_BACKGROUND+"Thank you! See you again."+ConsoleColors.RESET);
					System.out.println();
					main(args);
				}

				else {
					System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Choice. Please Enter The Correct Choice."+ConsoleColors.RESET);
					System.out.println();
				}

			}
		case 2:
			EngineerLoginUseCase engineerLogin = new EngineerLoginUseCase();
			System.out.println();
			int loggedIn=engineerLogin.loginAsEngineer();
			while(true) {
				System.out.println(ConsoleColors.PURPLE + "+--------------------------------------+" + "\n"
						+ "| 1. Check Assigned Complaints         |" + "\n"
						+ "| 2. Update The Complaint Status       |" + "\n"
						+ "| 3. History Of Attended Complaints    |" + "\n"
						+ "| 4. Change Password                   |" + "\n"
						+ "| 5. Exit                              |" + "\n"
						+ "+--------------------------------------+" + ConsoleColors.RESET);

				int choose = sc.nextInt();
				if(choose == 1) {
					GetAllAssignedComplaintsByHodUseCase complaintsAssigned = new GetAllAssignedComplaintsByHodUseCase();
					try {
						complaintsAssigned.assignedComplaintsToEngineer(loggedIn);
					} catch (ComplaintException e) {
						System.out.println(e.getMessage());
					}
				}else if(choose == 2) {
					UpdateTheStatusOfComplaintUseCase updateStatus = new UpdateTheStatusOfComplaintUseCase();
					updateStatus.updateStatus();
				}else if (choose == 3) {
					GetListOfAttendedComplaintsUseCase attendedComplaints = new GetListOfAttendedComplaintsUseCase();
					attendedComplaints.listOfAttendedComplaints(loggedIn);
				}else if(choose == 4) {
					ChangeYourPasswordEngineerUseCase changePassword = new ChangeYourPasswordEngineerUseCase();
					changePassword.changePasswordEngineer();
				}else if(choose == 5) {
					System.out.println();
					System.out.println(ConsoleColors.YELLOW_BACKGROUND+"Thank you! See you again."+ConsoleColors.RESET);
					System.out.println();
					main(args);
				}

			}
		case 3:
			while(true) {
				System.out.println();
				System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Employee Section"+ConsoleColors.RESET);
				System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"----------------"+ConsoleColors.RESET);
				System.out.println(ConsoleColors.PURPLE + "+-----------------+" + "\n"
						+ "| 1. LogIn        |" + "\n"
						+ "| 2. SignUp       |" + "\n"
						+ "| 3. Exit         |" + "\n"
						+ "+-----------------+" + ConsoleColors.RESET);

				int choose = sc.nextInt();
				if(choose == 1) {
					System.out.println();
					EmployeeLoginUseCase employee = new EmployeeLoginUseCase();
					int logIn=employee.loginAsEmployee();
					while(true) {
						System.out.println(ConsoleColors.PURPLE + "+-----------------------------------+" + "\n"
								+ "| 1. Register a Complaint.          |" + "\n"
								+ "| 2. Check Your Complaint Status    |" + "\n"
								+ "| 3. Your Complaints History.       |" + "\n"
								+ "| 4. Change Password                |" + "\n"
								+ "| 5. Logout.                        |" + "\n"
								+ "+-----------------------------------+" + ConsoleColors.RESET);

						int option = sc.nextInt();

						if(option == 1) {
							System.out.println();
							System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose your option: "+ConsoleColors.RESET);
							RegisterAComplaintUseCase compReg = new RegisterAComplaintUseCase();
							compReg.complaintRegister(logIn);
						}else if(option == 2) {
							GetStatusOfYourComplaintUseCase compStatus= new GetStatusOfYourComplaintUseCase();
							compStatus.complaint_Status(logIn);
						}else if(option == 3) {
							System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Your History of Complaints"+ConsoleColors.RESET);
							System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"--------------------------"+ConsoleColors.RESET);
							GetHistoryOfAllComplaintsUseCase compHistory = new GetHistoryOfAllComplaintsUseCase();
							compHistory.complaintHistory(logIn);
						}else if(option == 4) {
							ChangeYourPasswordEmployeeUseCase pwdChange = new ChangeYourPasswordEmployeeUseCase();
							System.out.println();
							pwdChange.changePasswordEmployee();
						}else if(option == 5) {
							System.out.println();
							System.out.println(ConsoleColors.YELLOW_BACKGROUND+"Thank you! See you again."+ConsoleColors.RESET);
							System.out.println();
							main(args);
						}else {
							System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid choice, please enter the correct chocie."+ConsoleColors.RESET);
						}
					}
				}else if(choose == 2) {
					System.out.println();
					EmployeeRegistrationUseCase employeeRegistration = new EmployeeRegistrationUseCase();
					employeeRegistration.empRegister();
				}else if(choose == 3){
					System.out.println();
					System.out.println(ConsoleColors.YELLOW_BACKGROUND+"Thank you! See you again."+ConsoleColors.RESET);
					System.out.println();
					main(args);
				}else {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid choice, please enter the correct chocie."+ConsoleColors.RESET);
				}
			}
		case 4:
			System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Thank you! See you again."+ConsoleColors.RESET);
			System.exit(0);
		}

	}

}