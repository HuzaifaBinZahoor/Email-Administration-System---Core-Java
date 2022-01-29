package com.huzaifabinzahoor.emailapp;
import java.util.*;
import java.io.FileWriter;
import java.io.*;

public class Email {
    public Scanner scan = new Scanner(System.in); // Scanner class
    // Declaring Variables as private for the project
    private String firstName;
    private String lastName;
        private String department;
    private String email;
    private String password;
    private int mailCapacity = 100;
    private String alterEmail;

    // Defining Constructors to initlize all the variables
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee is created: "+this.firstName+ " "+ this.lastName);
        // Invoking all the methods here
        this.department = this.setDepartment(); // this method will set the department for the employee
        this.password = this.generatePassword(10); // this method will set the password for the employee
        this.email = this.generateEmail(); // this method will set the email for the employee
    }
    // Method that will generate the email
    private String generateEmail(){
        return this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.department.toLowerCase()+".company.com";
    }
    // Method to get the department
    private String setDepartment(){
        System.out.println("Department Codes are as follow:- \n1- for Sales: \n2- for Development: \n3- for Accounting: \n4- for Social Media: \n0- for none: ");
        boolean flag = false;
        do{
            System.out.println("Enter Department Code = ");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 4:
                    return "SocialMedia";
                case 5:
                    return "None";
                default:
                    System.out.println("Invalid Choice: Please enter valid number again: ");

            }

        }while (!flag);
        return null;
    }

    // Method that will generate Random password
    private String generatePassword(int length){
        Random randomNumber = new Random();
        String capitalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallCharacters = "abcdefghijklmnopqrstuvwxyz";
        String Numbers = "0123456789";
        String Symbols = "!@#$%^&*()";
        String theValues = capitalCharacters+smallCharacters+Numbers+Symbols;
        String thePassword = "";
        for (int j=0; j<length;j++){
            thePassword = thePassword+theValues.charAt(randomNumber.nextInt(theValues.length()));
        }
        return thePassword;
    }

    // Method that will change the password
    public void setNewPassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password: (Y/N)");
            char choice = scan.next().charAt(0);
            if(choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password = ");
                String tempPassword = scan.next();
                if (tempPassword.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = scan.next();
                    System.out.println("Password changed successfully !! ");
                } else {
                    System.out.println("Incorrect Password !!");
                }
            }else if (choice == 'N' || choice == 'n'){
                    flag = true;
                    System.out.println("You have choosed not to change the password");

                }else {
                    System.out.println("Enter valid choice");
                }

        }while (!flag);
    }

    // Method that will set the capacity of mailbox
    public void setMailBoxCapacity(){
        System.out.println("Current Capacity is = "+this.mailCapacity+"mb");
        System.out.println("Enter new desired mailbox capacity = ");
        this.mailCapacity = scan.nextInt();
        System.out.println("The Mailbox Capacity has been successfully updated to: "+this.mailCapacity);
    }
    // method that will change the email address
    public void alterEmail(){
        System.out.println("Enter desired email = ");
        this.alterEmail = scan.next();
        System.out.println("Email has been updated to: "+this.alterEmail);
    }
    // Displaying user information
    public void getInfo(){
        System.out.println("New Employee:"+this.firstName+" "+this.lastName);
        System.out.println("Employee Department is: "+this.department);
        System.out.println("Employee Email is: "+this.email);
        System.out.println("Employee Password is: "+this.password); // this field is for testing purpose after that we should comment it out
        System.out.println("Employee Mailbox Capacity is: "+this.mailCapacity+"mb");
        System.out.println("Employee Alternate Email is: "+this.alterEmail);
    }

    // store all the data in file
    public void storeData(){
        try {
            Writer theFile = new FileWriter("C:\\Users\\Huzaifa Bin Zahoor\\OneDrive\\Desktop\\employee_data.txt");
            theFile.write("First Name: "+this.firstName);
            theFile.append("\n Last Name: "+this.lastName);
            theFile.append("\n Email: "+this.email);
            theFile.append("\n Password: "+this.password);
            theFile.append("\n Capacity: "+this.mailCapacity);
            theFile.append("\n Alternate Email: "+this.alterEmail);
            theFile.close();
            System.out.println("Data Stored....");

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Method that will read data from the file
    public void readDataFromFile(){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Huzaifa Bin Zahoor\\OneDrive\\Desktop\\employee_data.txt");
            int j;
            while((j=fileReader.read())!=-1){
                System.out.print((char)j);
            }
            fileReader.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

}
