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

    }
}
