package inventory;

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
        System.out.println("\n========== Inventory Added ==========");
        for (int i = 0; i < products.length; i++){
            System.out.println(products[i]); }
    }

    public static void addToInventory(Product[] products, Scanner in){
        String tempName;
        int tempNumber;
        int tempQty;
        double tempPrice;

        for (int i = 0; i < products.length; i++){
            in.nextLine(); // 5-b clear buffer,

            System.out.println("\n++++++++++ Enter Product " + ( i+1) + " Information ++++++++++");

            System.out.println("Name: ");
            tempName = in.nextLine();

            System.out.println("Item Number: ");
            tempNumber = in.nextInt();

            System.out.println("Quantity: ");
            tempQty = in.nextInt();

            System.out.println("Price: ");
            tempPrice= in.nextDouble();

            products[i] = new Product(tempName, tempNumber, tempQty, tempPrice);
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
