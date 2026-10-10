package myPack;

import java.util.Scanner;

@SuppressWarnings("serial")
class InvalidPhoneNumberExceptionn extends Exception{
	public InvalidPhoneNumberExceptionn(String dd){
		super(dd);
	}
}
public class Contact {
	
	long phonenumber;

	public Contact(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	String name;

	public Contact(String name) {
		this.name = name;
	}
	
	public static boolean timer() {
		for(int i=0; i<5; i++) {
			try {
				System.out.println("Adding contact.....");
			Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean timers() {
		for(int i=0; i<5; i++) {
			try {
				System.out.println("Please wait deleting contact.....");
			Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
//	5 persons phone number
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long phonenumber1 = 000000L;
		String name1="";
		System.out.println("---------- CONTACT MANAGEMENT SYSTEM --------");
		while (true) {
			System.out.println("1.Add contact\n2.View contact\n3.Search contact\n4.Delete contact\n5.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the phone number");
				phonenumber1 = sc.nextLong();
				Contact cc = new Contact(phonenumber1);
				int count = 0;
				int i = 0;
				while (i < cc.phonenumber) {
					long digit = cc.phonenumber % 10;
					count++;
					cc.phonenumber /= 10;
					i++;
				}
				
				if (count == 10) {
					System.out.println("Enter the name");
					name1 = sc.next(); // problem with nextLine
//					sc.next();
					Contact cs = new Contact(name1);
					if (cs.name.isEmpty()) {
						System.out.println("Names cannot be empty");
					} else {
						timer();
						System.out.println("Contacts Added Successfully");
					}
				} else {
					try {
					throw new InvalidPhoneNumberExceptionn("Phone Number Must Contain 10 Digits");
					}catch(InvalidPhoneNumberExceptionn r) {
						r.printStackTrace();
						return;
					}
				}
				break;
			case 2:
				if(name1.isEmpty() || phonenumber1==0) {
					System.out.println("Not contacts found");
				}
				else {
					System.out.println(" NAME          :"+name1);
					System.out.println(" PHONE NUMBER  :"+phonenumber1);
				}
				break;
			case 3:
				System.out.println("Enter the contacts name");
				String name4 = sc.next();
				if (name4.equalsIgnoreCase(name1)) {
					System.out.println("Contact Found");
					System.out.println("PHONE NUMBER   :"+phonenumber1);
				} else {
					System.out.println("Unavailable");
				}
				break;
			case 4:
				System.out.println("Enter the contacts name");
				String name5 = sc.next();
				if (name5.equalsIgnoreCase(name1)) {
					System.out.println("Do you want to delete the contacts yes / no" + " " + name1);
					String res = sc.next();
					timers();
					if (res.equalsIgnoreCase("yes")) {
						name1 = "";
						phonenumber1 = 0;
						System.out.println("Contacts Deleted Successfully");
					}
					else {
						System.out.println("Invalid");
					}
					
				} else {
					System.out.println("Invalid name or Contacts Not Available");
				}
				break;
			case 5:
				System.out.println("⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛THANK YOU FOR USING⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛⁛");
				return;
			}

		}
	}

}
