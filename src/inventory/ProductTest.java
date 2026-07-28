/*
Student Name: Durant, Gunnar Michael
Date: 27 July 2026
Assigned Prompt: Walk through the overridden toString() method in the DVD class. Why is it necessary to override it rather than use the one in Product? Show whether your DVD subclass can directly access the inherited fields from Product, such as name or price, without using getter methods, and explain why or why not based on the visibility modifiers in your own code. Then explain what the @Override annotation does and what would happen if you removed it. Would the method still work, and why is the annotation still considered good practice?

Live Demonstration Required: Temporarily remove the @Override annotation from your DVD toString() method and show whether the program still compiles and runs correctly. Then add a DVD and display it to confirm the output is unchanged. Next, temporarily try accessing an inherited field directly by name inside the DVD toString() method instead of through its getter, and show whether it compiles. Explain what the result tells you about visibility and subclass access in your implementation. Restore all changes before ending your recording.
 */

/*
AI  use:  had issues with "products[i] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength, tempAgeRating, tempStudio);" and similar error in constructor.
          got a mismatched int/str error.  Checked variable types and they matched names. Also checked for correct initialization, and syntax.
          asked basic google ai to list causes of error when initializing and assigning are same data type.
          Google explained error and listed several things to check.  Realized I had the data types out of order.  Error was gone after I rearranged order.
 */

package inventory;

import inventory.CD;
import inventory.DVD;
import inventory.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //Scanner object for keyboard input
        int maxSize, menuChoice;
        boolean exit = false;

        maxSize = getNumProducts(in);

        if (maxSize == 0){
            System.out.println("No products required!");}
        else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do{
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice !=0);

            displayInventory(products);
            }
        in.close();
    } //end method main

    public static int getNumProducts(Scanner in){
        int maxSize = -1;

        do {
            try {
                System.out.println("Enter the number of products you would like to add\n" +
                        "Enter 0(zero) if you do not wish to add products: ");

                maxSize = in.nextInt();

                if (maxSize < 0) {
                    System.out.println("Incorrect Value entered\n"); }
            } catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); } // 3-e add line to clear input buffer
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); } // e-e add line to clear input buffer}
        } while(maxSize < 0);
        return maxSize;
    }

    public static void displayInventory(Product[] products){
        System.out.println("\n========== Inventory ==========");
        for (int i = 0; i < products.length; i++){
            System.out.println(products[i]); }
    }

    // 6 update addToInventory to include choice
    public static void addToInventory(Product[] products, Scanner in){
        // 6-a remove existing variables, replace with single stockChoice
        int stockChoice = -1;

        for(int i = 0; i < products.length; i++){
            do {
                try{
                    // 6-b menu prompt
                    System.out.println("\n1: CD\n2: DVD\nPlease enter the product type: ");
                    stockChoice = in.nextInt();

                    // 6-c error message
                    if (stockChoice < 1 || stockChoice > 2){
                        System.out.println("Only numbers 1 or 2 allowed!");
                    }
                } catch (InputMismatchException e){
                    System.out.println("Incorrect data type entered!\n");
                    in.nextLine();
                }
            } while (stockChoice < 1 || stockChoice > 2); // 6-d

            if (stockChoice == 1){
                addCDToInventory(products, in); }
            else {
                addDVDToInventory(products, in);
            }
        }
    }

    // 5-a rename addToInventory to addCDToInventory
    public static void addCDToInventory(Product[] products, Scanner in){
        String tempName;
        int tempNumber;
        int tempQty;
        double tempPrice;
        // 5-b add additional variables included with CD
        String tempArtist;
        int tempSongs;
        String tempLabel;

        // 5-c update prompt
        for (int i = 0; i < products.length; i++){
            in.nextLine();

            System.out.println("\n++++++++++ Enter Product " + ( i+1) + " Information ++++++++++");

            System.out.println("Please enter the CD Name: ");
            tempName = in.nextLine();

            System.out.println("Please enter the Artist Name: ");
            tempArtist = in.nextLine();

            System.out.println("Please enter Record Label Name: ");
            tempLabel = in.nextLine();

            System.out.println("Please enter the Number of Songs: ");
            tempSongs = in.nextInt();

            System.out.println("Please enter Quantity of stock: ");
            tempQty = in.nextInt();

            System.out.println("Please enter Product Price: ");
            tempPrice = in.nextInt();

            System.out.println("Please enter Item Number: ");
            tempNumber = in.nextInt();

            // 5-d update product array
            products[i] = new CD(tempNumber, tempName, tempQty, tempPrice, tempArtist, tempSongs, tempLabel);
        }
    }

    // 5-e rename addToInventory to addCDToInventory
    public static void addDVDToInventory(Product[] products, Scanner in){
        String tempName;
        int tempNumber;
        int tempQty;
        double tempPrice;
        // 5-e add additional variables included with CD
        String tempStudio;
        int tempAgeRating;
        int tempLength;

        // 5-e update prompt
        for (int i = 0; i < products.length; i++){
            in.nextLine();

            System.out.println("\n++++++++++ Enter Product " + ( i+1) + " Information ++++++++++");

            System.out.println("Please enter the DVD Name: ");
            tempName = in.nextLine();

            System.out.println("Please enter the Film Studio Name: ");
            tempStudio = in.nextLine();

            System.out.println("Please enter the Age Rating: ");
            tempAgeRating = in.nextInt();

            System.out.println("Please enter the Length in minutes: ");
            tempLength = in.nextInt();

            System.out.println("Please enter Quantity of stock: ");
            tempQty = in.nextInt();

            System.out.println("Please enter the Product Price: ");
            tempPrice = in.nextInt();

            System.out.println("Please enter the Item Number: ");
            tempNumber = in.nextInt();

            // 5-e update product array
            products[i] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength, tempAgeRating, tempStudio);
        }
    }

    public static int getMenuOption(Scanner in){
        int menuChoice = -1;

        do{
            try {
                System.out.println("\n1. View Inventory");
                System.out.println("2. Add Stock");
                System.out.println("3. Deduct Stock");
                System.out.println("4. Discontinue Product");
                System.out.println("0. Exit");
                System.out.println("Enter Menue option: ");

                menuChoice = in.nextInt();

                if(menuChoice < 0 || menuChoice > 4){
                    System.out.println("Incorrect Value entered\n"); }
            } catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); }
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); }
        } while (menuChoice < 0 || menuChoice >4 );
        return menuChoice;
    }

    public static int getProductNumber(Product[] products, Scanner in){
        int productChoice = -1;

        do{
            try {
                System.out.println("\n----- Select a Product -----");
                for (int i=0; i < products.length; i++) {
                    System.out.print("Enter Product number: ");
                    productChoice = in.nextInt();

                    if (productChoice < 0 || productChoice >= products.length)
                        System.out.println("Incorrect Value: Enter number between 0 and " + (products.length) + "\n"); }

            }catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); }
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); }
        } while (productChoice < 0 || productChoice >= products.length);
        return  productChoice;
    }

    public static void addInventory(Product[] products, Scanner in){
        int productChoice;
        int updateValue =-1;

        productChoice = getProductNumber(products, in);

        // 8 prevent adding to discontinued product
        if (!products[productChoice].isStatus()){
            System.out.println("Cannot add to discontinued product");
            return;
        }

        do{
            try{
                System.out.print("How many products do you want to add? ");
                updateValue = in.nextInt();

                if (updateValue < 0) {
                    System.out.println("Incorrect Value: Enter number between 0 or greater.\n");
                }
            } catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); }
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); }
        } while (updateValue < 0);

        products[productChoice].addToInventory(updateValue);
        System.out.println("Stock updated successfully.");
    }

    public static void deductInventory(Product[] products, Scanner in) {
        int productChoice;
        int updateValue = -1;

        productChoice = getProductNumber(products, in);

        do {
            try {
                System.out.print("How many products do you want to deduct? ");
                updateValue = in.nextInt();

                if (updateValue < 0 || updateValue > products[productChoice].getQtyInStock()) {
                    System.out.println("Incorrect Value: Enter number between 0 and (" + products[productChoice].getQtyInStock() + ").\n");
                }
            } catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); }
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); }
        } while (updateValue < 0 || updateValue > products[productChoice].getQtyInStock());

        products[productChoice].duductFromInventory(updateValue);
        System.out.println("Stock deducted successfully.");
    }

    public static void discontinueInventory(Product[] products, Scanner in) {
        int productChoice;

        productChoice = getProductNumber(products, in);

        products[productChoice].setStatus(false);
        System.out.println("Product has been discontinued.");
    }

    public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
        if (menuChoice == 1) {
            System.out.println("\nView Product List");
            displayInventory(products);
        } else if (menuChoice == 2) {
            System.out.println("\nAdd Stock");
            addInventory(products, in);
        } else if (menuChoice == 3) {
            System.out.println("\nDeduct Stock");
            deductInventory(products, in);
        } else if (menuChoice == 4) {
            System.out.println("\nDiscontinue Stock");
            discontinueInventory(products, in);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
