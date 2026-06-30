package inventory;

public class ProductTest {
    public static void main(String[] args){
        //two items using default constructor
        Product item1 = new Product();
        Product item2 = new Product();

        //four items using values
        Product item3 = new Product("Charizard", "TrainerBox", 12, 85.50);
        Product item4 = new Product("Pikachu", "Plushy", 25, 38.75);
        Product item5 = new Product("Squirtle", "tradingCard", 4, 25.15);
        Product item6 = new Product("Master Ball", "toy", 3, 45.50);

        System.out.println("---------- Pokemon Inventory System ----------\n");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
        System.out.println(item5);
        System.out.println(item6);
    }
}
