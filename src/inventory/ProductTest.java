package inventory;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //scanner called in
        boolean exit = false;

        //local temp variables
        String tempName;
        String tempType;
        int tempQty;
        double tempPrice;

        //for p1
        System.out.println("Enter product information; \n");
        System.out.println("Name: ");
        tempName = in.nextLine();
        System.out.println("Type: ");
        tempType = in.nextLine();
        System.out.println("Quantity: ");
        tempQty = in.nextInt();
        System.out.println("Price: ");
        tempPrice = in.nextDouble();
        //create new object, print results
        Product p1 = new Product(tempName, tempType, tempQty, tempPrice);
        System.out.println("New Item Entered: ");
        System.out.println(p1);

        //for p2
        System.out.println("Enter product information; \n");
        System.out.println("Name: ");
        tempName = in.nextLine();
        System.out.println("Type: ");
        tempType = in.nextLine();
        System.out.println("Quantity: ");
        tempQty = in.nextInt();
        System.out.println("Price: ");
        tempPrice = in.nextDouble();
        Product p2 = new Product(tempName, tempType, tempQty, tempPrice);
        in.nextLine();
        System.out.println(p1);
        //close scanner
        in.close();


        //two items using default constructor
        System.out.println("\n----------Default----------");
        Product item1 = new Product();
        Product item2 = new Product();

        //four items using values
        Product item3 = new Product("Charizard", "TrainerBox", 12, 85.50);
        Product item4 = new Product("Pikachu", "Plushy", 25, 38.75);
        Product item5 = new Product("Squirtle", "tradingCard", 4, 25.15);
        Product item6 = new Product("Master Ball", "toy", 3, 45.50);

        //printout of all items
        System.out.println("---------- Pokemon Inventory System ----------\n"); //flavor text
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
        System.out.println(item5);
        System.out.println(item6);

        Product backup = item3;
        backup.setInStock(777);

        System.out.println(backup.getInStock());
        System.out.println(item3.getInStock());
        System.out.print(item4.getInStock());
    }
}
