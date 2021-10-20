import java.util.*;
import java.text.DecimalFormat;
import java.io.IOException;

public class MainMenu extends Account {

    Scanner reader = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int l = 1;
        do {
            try {
                data.put(832688, 190283);
                data.put(217532, 583326);
                data.put(928366, 811049);
                data.put(925070, 456966);
                data.put(841237, 459001);
                data.put(123456, 589741);

                System.out.println("Welcome to BIT ATM");
                System.out.println("Please Enter your Customer Number :  ");
                setCustomerNumber(reader.nextInt());

                System.out.println("Enter your PIN NUmber :   ");
                setPinNumber(reader.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Characters" + "\n");
                e.printStackTrace();
                l = 2;
            }

            int cust_no = getCustomerNumber();
            int pin_no = getPinNumber();

            if (data.containsKey(cust_no) && data.get(cust_no) == pin_no) {

                getAccountType();
            } else {
                System.out.println("\n Wrong Customer Number or PIN Number \n");
            }
        } while (l == 1);
    }

    public void getAccountType() {

        System.out.println("Please Enter the account you want to access :   ");
        System.out.println("Press 1 - Your Current Account");
        System.out.println("Press 2 - Saving Account");
        System.out.println("Press 3 - Exit");

        int key = reader.nextInt();
        switch (key) {
        case 1:
            getCurrent();
            break;

        case 2:
            getSaving();
            break;

        case 3:
            System.out.println("GoodBye! Thank you for using BIT ATM.");
            break;

        default:
            System.out.println("Invalid choice");
            getAccountType();
        }
    }

    public void getCurrent() {

        System.out.println("You Current Account");
        System.out.println("Press 1 : view balance");
        System.out.println("Press 2 : withdraw money");
        System.out.println("Press 3 : deposit money");
        System.out.println("Choice:  ");

        int key = reader.nextInt();
        switch (key) {

        case 1:
            System.out.println("You current Balance :   " + moneyFormat.format(getCurrentBalance()));
            getAccountType();
            break;

        case 2:
            getCurrentWithdrawInput();
            getAccountType();
            break;

        case 3:
            getCurrentDepositInput();
            getAccountType();
            break;
        }
    }

    public void getSaving() {
        System.out.println("You Current Account");
        System.out.println("Press 1 : view balance");
        System.out.println("Press 2 : withdraw money");
        System.out.println("Press 3 : deposit money");
        System.out.println("Choice:  ");

        int key = reader.nextInt();

        switch (key) {

        case 1:
            System.out.println("Saving Account Balance :  " + moneyFormat.format(getSavingBalance()));
            getAccountType();
            break;

        case 2:
            getSavingWithdrawInput();
            getAccountType();
            break;

        case 3:
            getSavingDepositInput();
            getAccountType();
            break;

        case 4:
            System.out.println("Goodbye! Thanks for using the ATM.");
            break;

        default:
            System.out.println("\n Invalid Choices \n");
            getCurrent();
        }
    }
}
