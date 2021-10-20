import java.util.*;
import java.text.DecimalFormat;

public class Account {

    Scanner reader = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");
    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;

    public int setCustomerNumber(int customerNumber){

        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }
    
    public int setPinNumber(int pinNumber){
        
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    
    public int getPinNumber(){
        return pinNumber;
    }

    public double getCurrentBalance(){

        return currentBalance;
    }

    public double getSavingBalance(){

        return savingBalance;
    }
    public double calCurrentDeposit(double amount){
        currentBalance = currentBalance + amount;
        return currentBalance;
    }
    public double calCurrentWithdraw(double amount){
        currentBalance = currentBalance - amount;
        return currentBalance;
    }

    public double calSavingWithdraw(double amount){
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    public double calSavingDeposit(double amount){
        savingBalance = savingBalance + amount;
        return savingBalance;
    }
    public void getCurrentWithdrawInput(){

        System.out.println("Your current Balance :  " + moneyFormat.format(currentBalance));
        System.out.println("Enter the amount of money you want to withdraw :  ");
        double amount = reader.nextDouble();

        if(currentBalance - amount >= 0){
            calCurrentWithdraw(amount);
            System.out.println("New Balance :   " + moneyFormat.format(currentBalance));
        }
        else{
            System.out.println("\n Sorry! You don't have enough money.\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Your Saving Balance :  " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount of money you want to withdraw :  ");
        double amount = reader.nextDouble();

        if(savingBalance - amount >= 0){
            calSavingWithdraw(amount);
            System.out.println("New Balance :   " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("\n Sorry! You don't have enough money.\n");
        }
    }
    public void getCurrentDepositInput(){

        System.out.println("Your current Balance :  " + moneyFormat.format(currentBalance));
        System.out.println("Enter the amount of money you want to deposit :  ");
        double amount = reader.nextDouble();

        if(currentBalance + amount >= 0){
            calCurrentDeposit(amount);
            System.out.println("Your new Balance is :    " + moneyFormat.format(currentBalance));
        }
        else{

            System.out.println("Sorry! Invalid");
        }
    }

    public void getSavingDepositInput(){

        System.out.println("Your Saving Balance :  " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount of money you want to deposit :  ");
        double amount = reader.nextDouble();

        if(savingBalance + amount >= 0){
            calSavingDeposit(amount);
            System.out.println("Your new Saving Balance is :    " + moneyFormat.format(savingBalance));
        }
        else{

            System.out.println("Sorry! Invalid");
        }
    }
}
