/*
Student Name: Durant Gunnar MIchael
Date: 15 July 2026
Assigned Prompt: Walk through the do-while loop that collects the maxSize value from the user. Explain why a do-while loop is used here instead of a regular while loop. Show the exact condition on the while clause and explain why the initial value of maxSize matters for that condition.

Live Demonstration Required: Run the program live and enter -3 to show the error message. Then, without restarting, enter a letter to show the exception handling. Then enter a valid number to show full recovery. As you go, explain what the loop condition is evaluating at each re-entry point.
 */
package inventory;

import inventory.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //scanner called in
        boolean exit = false;

        //local temp variables
        String tempName;
        int tempNumber;
        int tempQty;
        double tempPrice;
        int maxSize = -1; // 2-a creat maxSize variable, 3-c

        // 2-c add do while loop
        do {
            //add a try block that surrounds all code inside while loop
            try {
                // 2-b prompt at start of main to instruct user
                System.out.println("Enter the number of products you would like to add\n" +
                        "Enter 0(zero) if you do not wish to add products: ");

                maxSize = in.nextInt();

                if (maxSize < 0) {
                    System.out.println("Incorrect Value entered\n");
                }
            }
            // 3-a add catch statement above while, exception e parameter.
            catch (InputMismatchException e){
                System.out.println("Incorrect data type entered!\n");
                in.nextLine(); } // 3-e add line to clear input buffer
            catch (Exception e){
                System.out.println("An unexpected error occurred: " + e + "\n");
                in.nextLine(); } // e-e add line to clear input buffer}
        } while(maxSize < 0);

        // 4-a if statement to display text if maxSize is 0
        if (maxSize == 0){
            System.out.println("No products required!");
        }
        //4-b add else statement for other values
        else {
            // 4-b array to store products
            Product[] products = new Product[maxSize];

            // 5-a loop to collect product info
            for (int i = 0; i < products.length; i++){
                in.nextLine(); // 5-b clear buffer,

                System.out.println("\n++++++++++ Enter Product " + ( i+1) + " Information ++++++++++");

                // 5-c copy code used to get input from user into loop
                System.out.println("Name: ");
                tempName = in.nextLine();

                System.out.println("Item Number: ");
                tempNumber = in.nextInt();

                System.out.println("Quantity: ");
                tempQty = in.nextInt();

                System.out.println("Price: ");
                tempPrice= in.nextDouble();

                // 5-d initiate  and assign object to array
                products[i] = new Product(tempName, tempNumber, tempQty, tempPrice);
                //got a can't resolve/unkown name error here.  used ai to explain error, and causes.
                // noticed variables needed and sent from constructor were not matching up.
            }

            // 6 loop to display information
            System.out.println("\n========== Inventory Added ==========");
            for (int i = 0; i < products.length; i++){
                System.out.println(products[i]);}
            }

        in.close(); //close scanner
    }
}
