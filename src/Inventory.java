public class Inventory {
    private static int nextItemNumber = 1;
    int itemNumber;//assigns item number
    String name;//for unit name
    int inStock;//keeps track of inventory
    double price;//keeps track of unit price

    //default constructor
    public Inventory(){
        this.itemNumber = nextItemNumber;
        this.name = "unkItem"+this.itemNumber;
        this.inStock = 0;
        this.price = 0.0;
        nextItemNumber++; } //increases nextItemNumber
    //constructor with parameters
    public Inventory(String name, int inStock, double price){
        this.itemNumber = nextItemNumber;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
        nextItemNumber++; }


}
