package inventory;

public class Product {
    private int itemNumber;
    private boolean active = true; //bool for sales
    private String name;//for unit name
    private int inStock;//keeps track of inventory
    private double price;//keeps track of unit price

    //default constructor
    public Product() {
        this.active = true;
        this.name = name;
        this.itemNumber = itemNumber;
        this.inStock = inStock;
        this.price = price;
    }


    //constructor with parameters
    public Product(String name, int itemNumber, int inStock, double price){
        this.active = true;
        this.name = name;
        this.itemNumber = itemNumber;
        this.inStock = inStock;
        this.price = price;
    }
    //all getters
    public boolean isActive(){ return active; }
    public String getName(){ return name; }
    public int getItemNumber(){ return itemNumber; }
    public int getInStock(){ return inStock; }
    public double getPrice(){ return price; }

    public double getInventoryValue(){
        return this.price * this.inStock;}

    //all setters
    public void setActive(boolean active){ this.active = active; }
    public void setName(String name){ this.name = name; }
    public void setItemNumber(int itemNumber){ this.itemNumber = itemNumber; }
    public void setInStock(int inStock) { this.inStock = inStock; }
    public void setPrice(double price) { this.price = price; }

    //toString updated, includes getInventory
    @Override
    public String toString(){
        return  "Item Number      : " + this.itemNumber + "\n" +
                "Name             : " + this.name + "\n" +
                "Quantity in stock: " + this.inStock + "\n" +
                "Price            : " + this.price + "\n" +
                "Stock Value      : " + this.getInventoryValue() + "\n" +
                "Product Status   : " + (this.active ? "Active" : "Discontinued") + "\n";
        //ternary operator to simplify boolean output
    }

}
