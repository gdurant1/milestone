public class Product {
    private static int nextItemNumber = 1;
    private int itemNumber;//assigns item number
    private String name;//for unit name
    private int inStock;//keeps track of inventory
    private double price;//keeps track of unit price

    //default constructor
    public Product(){
        this.itemNumber = nextItemNumber;
        this.name = "unkItem"+this.itemNumber;
        this.inStock = 0;
        this.price = 0.0;
        nextItemNumber++; } //increases nextItemNumber
    //constructor with parameters
    public Product(String name, int inStock, double price){
        this.itemNumber = nextItemNumber;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
        nextItemNumber++; }
    //all getters
    public int getItemNumber(){ return itemNumber; }
    public String getName(){ return name; }
    public int getInStock(){ return inStock; }
    public double getPrice(){ return price; }
    //all setters
    public void setName(String name){ this.name = name;}
    public void setInStock(int inStock) { this.inStock = inStock; }
    public void setPrice(double price) { this.price = price; }

}
