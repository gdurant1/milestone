package inventory;

public class Product {
    private int itemNumber; //user assigned item number
    private boolean active = true; //bool for sales
    private String name;//for unit name
    private int QtyInStock;//keeps track of inventory
    private double price;//keeps track of unit price

    //default constructor
    public Product() {
        this.active = true;
        this.name = name;
        this.itemNumber = itemNumber;
        this.QtyInStock = QtyInStock;
        this.price = price;
    }

    //constructor with parameters
    public Product(String name, int itemNumber, int inStock, double price){
        this.active = true;
        this.name = name;
        this.itemNumber = itemNumber;
        this.QtyInStock = inStock;
        this.price = price;
    }
    //all getters
    public boolean isActive(){ return active; }
    public String getName(){ return name; }
    public int getItemNumber(){ return itemNumber; }
    public int getQtyInStock(){ return QtyInStock; }
    public double getPrice(){ return price; }

    //all setters
    public void setActive(boolean active){ this.active = active; }
    public void setName(String name){ this.name = name; }
    public void setItemNumber(int itemNumber){ this.itemNumber = itemNumber; }
    public void setQtyInStock(int qtyInStock) { this.QtyInStock = qtyInStock; }
    public void setPrice(double price) { this.price = price; }

    public double getInventoryValue(){
        return this.price * this.QtyInStock;}

    // JP 4 #3 number 3
    public void addToInventory(int quantity){
        if(quantity > 0) {
            this.QtyInStock += quantity;
        }
    }

    // JP 4 #3 number 2
    public void duductFromInventory(int quantity){
        if (quantity > 0 && this.QtyInStock >= quantity){
            this.QtyInStock -= quantity;
        }
    }

    //toString updated, includes getInventory
    @Override
    public String toString(){
        return  "Item Number      : " + this.itemNumber + "\n" +
                "Name             : " + this.name + "\n" +
                "Quantity in stock: " + this.QtyInStock + "\n" +
                "Price            : " + this.price + "\n" +
                "Stock Value      : " + this.getInventoryValue() + "\n" +
                "Product Status   : " + (this.active ? "Active" : "Discontinued") + "\n";
        //ternary operator to simplify boolean output
    }

}
