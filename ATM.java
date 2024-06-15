import java.util.Scanner;

public class ATM {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to El-DeeB bank");

        int ids[] = { 123, 777, 888, 989, 798, 465, 654, 651 };
        int balance[] = { 100, 500, 600, 10, 444, 600, 800, 891 };

int home =1;
    while (home != 0) {

          boolean menu = true;



        boolean check = true;



        int index = -1;
        while (index == -1) {
            System.out.println("please enter your id:");
            int id = input.nextInt();

            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == id) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Not found!");
                continue;
            }
        }

        while (check) {
           while (menu) {

               System.out.println("~~~~~~~~~~~~~~~");
               System.out.println("balance : 1");
               System.out.println("withdraw : 2");
               System.out.println("deposite : 3");
               System.out.println("transfer : 4");
               System.out.println("exit : 0");
               System.out.println("~~~~~~~~~~~~~~~");
               System.out.println("enter number :");
               int choice = input.nextInt();

               switch (choice) {
                   case 1:
                       System.out.println("your balance :" + balance[index]+" $");
                       break;
                   case 2:
                       System.out.println("enter amount to withdraw :");
                       int amount = input.nextInt();

                       if (amount <= balance[index]) {
                           balance[index] = balance[index] - amount;
                           System.out.println("You have withdrawn " + amount + "$" + ". Your new balance is " + balance[index] + "$");
                       } else {
                           System.out.println("Insufficient balance.");
                       }
                       break;
                   case 3:
                       System.out.println("enter amount to deposit :");
                       amount = input.nextInt();

                       balance[index] =balance[index] + amount;
                       System.out.println("You have deposited " + amount + "$" + ". Your new balance is " + balance[index] + "$");
                       break;
                   case 4:
                       System.out.println("enter ACCOUNT number to transfer :");
                       int transferAccount = input.nextInt();
                       if (transferAccount == ids[index]) {
                           System.out.println("Cannot transfer to your account");
                           break;
                       }
                       System.out.println("enter amount to transfer :");
                       amount = input.nextInt();

                       int recipient = -1;
                       for (int i = 0; i < ids.length; i++) {
                           if (ids[i] == transferAccount) {
                               recipient = i;
                               break;
                           }
                       }

                       if (recipient == -1) {
                           System.out.println("Invalid account number.");
                       } else if (amount <= balance[index]) {
                           balance[index] =balance[index] - amount;
                           balance[recipient] =balance[recipient] + amount;
                           System.out.println("You have transferred " + amount + "$" + " to account number " + transferAccount + ". Your new balance is " + balance[index] + "$");
                       } else {
                           System.out.println("Insufficient balance.");
                       }
                       break;
                   case 0:
                       menu = false;

                       break;
                   default:
                       System.out.println("Invalid choice.");
                       break;
               }

           }
           break;
       }
        System.out.println("To return home : 1");
        System.out.println("To exit : 0");




        home = input.nextInt();



    }
}}
