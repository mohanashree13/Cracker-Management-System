 package Main;

import java.util.*;

import View.*;

public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		boolean b=true;
        do
        {
            System.out.print("Enter 1 for login or Press 2 for Signup : ");
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1)
            {
                UserView.loginPage();
                // UserController.checkLogin();
            }
            else if(n==2)
            {
                UserView.signin();
            }
            else
                System.out.println("----Enter only 1 or 2 ---- ");
        }
        while(b);

	}

}
