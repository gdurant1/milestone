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

        System.out.println("Enter product information; \nType STOP to exit");
        do {
            //create way to exit first
            System.out.println("Type 'STOP' to exit or Enter Name \nName: ");
            tempName = in.nextLine();
            //exit or continue loop
            if (tempName.equalsIgnoreCase("STOP")){exit=true;}
            else {
            System.out.println("Type: ");
            tempType = in.nextLine();
            System.out.println("Quantity: ");
            tempQty = in.nextInt();
            System.out.println("Price: ");
            tempPrice = in.nextDouble();
            in.nextLine(); }
        } while (!exit);



        //two items using default constructor
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
