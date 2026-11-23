package SalaryBank;

import java.util.Scanner;

public class salarybankclass {

    public static double calculateBonus(double salary, int yearsOfService){
        double bonus = 0;
        if(yearsOfService > 10){
            bonus = salary*0.20;
        }
        else if(yearsOfService > 5){
            bonus = salary*0.10;
        }
        else{
            bonus = 0;
        }
        return bonus;
    }

    public static double calculateTax(double salary){
        double tax;
        if(salary < 30000){
            tax = salary*0.05;
        }
        else if(salary <= 70000){
            tax = salary*0.10;
        }
        else{
            tax = salary*0.15;
        }
        return tax;
    }

    public static void generateSalarySlip(String employeeName, double salary, int yearsOfService){
        double bonus = calculateBonus(salary, yearsOfService);
        double tax = calculateTax(salary);
        double netsalary = salary + bonus - tax;

        System.out.println("Employee Name : "+employeeName);
        System.out.println("Years of Service : "+yearsOfService);
        System.out.println("Base Salary = "+salary);
        System.out.println("Bonus = "+bonus);
        System.out.println("Tax = "+tax);
        System.out.println("Net Salary = "+netsalary);
    }

    public static double deposit(double balance, double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return balance;
        }
        balance = balance + amount;
        System.out.println("Deposited = "+amount);
        return balance;
    }

    public static double withdraw(double balance, double amount){
        if(amount > balance){
            System.out.println("Insufficient balance, withdrawal not allowed");
            return balance;
        }
        balance = balance - amount;
        System.out.println("Withdrawn = "+amount);
        return balance;
    }

    public static double calculateInterest(double balance, int years){
        double totalamount = balance;
        for(int i=1; i<=years; i++){
            totalamount = totalamount + totalamount*0.08;
        }
        return totalamount - balance;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("enter employee name: ");
        String employeeName = input.next();
        System.out.println("enter salary: ");
        double salary = input.nextDouble();
        System.out.println("enter years of service: ");
        int yearsOfService = input.nextInt();
        generateSalarySlip(employeeName, salary, yearsOfService);

        System.out.println("enter bank balance: ");
        double balance = input.nextDouble();
        System.out.println("enter amount to deposit: ");
        double depositAmount = input.nextDouble();
        balance = deposit(balance, depositAmount);
        System.out.println("Balance = "+balance);

        System.out.println("enter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        balance = withdraw(balance, withdrawAmount);
        System.out.println("Balance = "+balance);

        System.out.println("enter number of years: ");
        int years = input.nextInt();
        double interest = calculateInterest(balance, years);
        System.out.println("Interest = "+interest);
        System.out.println("Total amount = "+(balance+interest));
    }
}
