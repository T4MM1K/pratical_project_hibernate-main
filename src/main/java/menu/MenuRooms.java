package menu;

import persistence.RepositoryRoom;

import java.util.Scanner;

public class MenuRooms {
    RepositoryRoom repositoryRoom = new RepositoryRoom();


    private int menuOptions(Scanner input) {
        System.out.println("\n/***********************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Search room by ID");
        System.out.println("2: Update room by ID");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***********************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {
        int userChoice;

        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuSearchRoomById(input);
                    break;
                case 2:
                    menuUpdateRoomPriceById(input);
                    break;
                case 3:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
    }

    private void menuSearchRoomById(Scanner input) {
        System.out.println("Search room by ID");
        int roomTypeId = input.nextInt();
        System.out.println(repositoryRoom.searchRoomById(roomTypeId));
    }

    private void menuUpdateRoomPriceById(Scanner input) {
        System.out.println("Update room price by ID");
        System.out.println("Enter room ID: ");
        int roomTypeId = input.nextInt();
        System.out.println("Enter a new price: ");
        String newPrice = input.next();
        repositoryRoom.updateRoomPriceById(newPrice, roomTypeId);
    }
}
