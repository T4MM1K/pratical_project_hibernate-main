package menu;

import java.util.List;
import java.util.Scanner;
import model.Customers;
import persistence.RepositoryCustomer;

public class MenuCustomers {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Save new customer");
        System.out.println("3: List total of customers");
        System.out.println("4: List total of bookings by checkout date");
        System.out.println("5: Update customers phone number by customer id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllCustomers(input);
                    break;
                case 2:
                    menuSaveCustomer(input);
                    break;
                case 3:
                    menuListTotalOfCustomers();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }



    private void menuListAllCustomers(Scanner input) {
        List<Customers> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customers cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

    private void menuSaveCustomer(Scanner input) {
        Customers customer = new Customers();
        System.out.println("Menu save new customer");

        String name;
        System.out.println("Type the first name: ");
        name = input.next();
        if (!name.matches("^[a-zA-Z]{3,20}$")) {
            System.out.println("Invalid name! Try again.");
            name = input.next();
        }
        customer.setFirstName(name);

        String lastName;
        System.out.println("Type the last name: ");
        lastName = input.next();
        if (!lastName.matches("^[a-zA-Z]{3,20}$")) {
            System.out.println("Invalid last name! Try again.");
            lastName = input.next();
        }
        customer.setLastName(lastName);

        System.out.println("Type the address: ");
        customer.setAddress(input.next());
        System.out.println("Type the postal code: ");
        customer.setPostalCode(input.next());

        String phoneNumber;
        System.out.println("Type the phone number: ");
        phoneNumber = input.next();
        if (!phoneNumber.matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")) {
            System.out.println("Invalid phone number! Try again.");
            phoneNumber = input.next();
        }
        customer.setPhoneNumber(phoneNumber);

        String email;
        System.out.println("Type the email: ");
        email = input.next();
        if (!email.matches("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$")) {
            System.out.println("Invalid email! Try again.");
            email = input.next();
        }
        customer.setEmail(email);

        System.out.println("Type the country: ");
        customer.setCountry(input.next());
        System.out.println("Type the city: ");
        customer.setCity(input.next());

        repositoryCustomer.saveCustomer(customer);
        System.out.println("Customer saved successfully!");
    }

    public void menuListTotalOfCustomers() {
        long result = repositoryCustomer.listTotalOfCustomers();
        System.out.println("Total number of customers is: " + result);
        if (result <= 0) {
            System.out.println("There are no customers registered.");
        }
    }
}
