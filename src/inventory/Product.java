package inventory;
public class Product {
    //instance field declarations
    private static long nextItemNumber = 1;
    private long itemNumber;//assigns item number
    private String name;//for unit name
    private String itemType;//to sort by product types
    private int inStock;//keeps track of inventory
    private double price;//keeps track of unit price

    //default constructor
    public Product(){
        this.itemNumber = nextItemNumber;
        this.name = "unkItem"+this.itemNumber;
        this.itemType = "unkType"+this.itemNumber;
        this.inStock = 0;
        this.price = 0.0;
        nextItemNumber++; } //increases nextItemNumber
    //constructor with parameters
    public Product(String name, String itemType, int inStock, double price){
        this.itemNumber = nextItemNumber;
        this.name = name;
        this.itemType = itemType;
        this.inStock = inStock;
        this.price = price;
        nextItemNumber++; }
    //all getters
    public long getItemNumber(){ return itemNumber; }
    public String getName(){ return name; }
    public String getItemType(){ return itemType; }
    public int getInStock(){ return inStock; }
    public double getPrice(){ return price; }
    //all setters
    //itemNumber does not need setter due to it being static
    public void setName(String name){ this.name = name; }
    public void setItemType(String itemType){ this.itemType = itemType; }
    public void setInStock(int inStock) { this.inStock = inStock; }
    public void setPrice(double price) { this.price = price; }

    //toString with override to help print inventory
    @Override
    public String toString(){
        return  "Item Number      : " + this.itemNumber + "\n" +
                "Name             : " + this.name + "\n" +
                "Product Type     : " + this.itemType + "\n" +
                "Quantity in stock: " + this.inStock + "\n" +
                "Price            : " + this.price + "\n";
    }

}
