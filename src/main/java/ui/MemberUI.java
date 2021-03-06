package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.DuplicateKeyException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.*;
import controller.MemberController;;

public class MemberUI {
	public MemberController ctrl;
	Scanner in;
	
	public MemberUI(MemberController ctrl)
	{
		this.ctrl=ctrl;
		this.in=new Scanner(System.in);
	}
	
	public MemberController getCtrl()
	{
		return this.ctrl;
	}
	
	public Scanner getIn()
	{
		return this.in;
	}
	
	public void setCtrl(MemberController newCtrl)
	{
		this.ctrl=newCtrl;
	}
	
	public void setIn(Scanner newIn)
	{
		this.in=newIn;
	}
	
	public void printMenu()
	{
		String menu;
		menu="Budget Admin Menu: \n";
		menu +="\t 1 - to add a new member; \n";
		menu +="\t 2 - to add a new income/cost; \n";
		menu +="\t 3 - to list the current income/cost; \n";
		menu +="\t 0 - exit \n";
		
		System.out.println(menu);
	}
	
	
	public void Run()
	{
		printMenu();
	
		
		int cmd=in.nextInt();
		in.nextLine();
		
		while(cmd!=0)
		{
			if(cmd==1)
			{								
				System.out.println("Enter name:");
				String name = in.nextLine();
				System.out.println("Enter id:");
				String ids = in.nextLine();
				try {
					int id = Integer.parseInt(ids);
					ctrl.addMember(name, id);
					System.out.println("Operation successful.");
				}
				catch (NumberFormatException e){
					System.out.println("This value must be an integer.");
				} catch (InvalidNameException e) {
					System.out.println(e.getMessage());
				} catch (DuplicateKeyException e) {
					System.out.println("Id must be unique.");
				} catch (InvalidIdException e) {
					System.out.println(e.getMessage());
				}
			}
			if(cmd==2)
			{
				
				
				System.out.println("Enter type:");
				String type = in.nextLine();
				
				System.out.println("Enter the value:");
				String valueS = in.nextLine();
				try {
					int valueInt = Integer.parseInt(valueS);
					System.out.println("Enter the id of the member:");
					String idS = in.nextLine();
					int idInt=Integer.parseInt(idS);


					ctrl.addEntry(type, valueInt, idInt);
					System.out.println("Operation successful.");
				}
				catch (NumberFormatException e){
					System.out.println("This value must be an integer.");
				} catch (InvalidIdException e) {
					e.printStackTrace();
				} catch (InvalidTypeException e) {
					e.printStackTrace();
				}


			}
			if(cmd==3)
			{
				System.out.println("list the current budget :");
				
									
				
				List<Entry> allE= ctrl.allEntries();
				for (int j=0;j<allE.size();j++)
					System.out.println(allE.get(j).toString());				
			}

			printMenu();
			cmd=in.nextInt();
			in.nextLine();
		}
	}
}

