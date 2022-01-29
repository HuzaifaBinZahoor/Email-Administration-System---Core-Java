package com.huzaifabinzahoor.emailapp;
import java.util.*;

public class emailAppMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Main method will get then use basic info from here
        System.out.println("Please Enter your First Name = ");
        String firstName = scan.next();
        System.out.println("Please Enter your Last Name = ");
        String lastName = scan.next();

        // creating the object for Email class
        Email newEmail = new Email(firstName,lastName);
        int choice = -1;
        do{
            System.out.println("\n>>>>>>\nEnter your choice \n" +
                    "1- Show Employee Complete Information: " +
                    "\n" +
                    "2- Change Employee Account Password: " +
                    "\n" +
                    "3- Change Employee Mailbox Capacity: " +
                    "\n" +
                    "4- Set an Alternate Email for recovery: " +
                    "\n" +
                    "5- Store Data in File: " +
                    "\n" +
                    "6- Read Data From File: " +
                    "\n" +
                    "7- Exit");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    newEmail.getInfo();
                    break;
                case 2:
                    newEmail.setNewPassword();
                    break;
                case 3:
                    newEmail.setMailBoxCapacity();
                    break;
                case 4:
                    newEmail.alterEmail();
                    break;
                case 5:
                    newEmail.storeData();
                    break;
                case 6:
                    newEmail.readDataFromFile();
                    break;
                case 7:
                    System.out.println("Thank you for using the application services");
                    break;
                default:
                    System.out.println("Invalid Choice! " +
                            "\n" +
                            "Enter valid choice again");
            }
        }while (choice!=5);
    }
}
