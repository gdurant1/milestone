package inventory;

// JP 5 2-a create subclass of product class called DVD
public class DVD extends Product {
    // 2-a additional instances
    private int lengthMinutes;
    private int ageRating;
    private String filmStudio;

    // 2-b constructor using super
    public DVD (int itemNumber, String name, int QtyInStock, double price,
                int lengthMinutes, int ageRating, String filmStudio){
        super(name, itemNumber, QtyInStock, price);
        this.lengthMinutes = lengthMinutes;
        this.ageRating = ageRating;
        this.filmStudio = filmStudio;
    }

    // 2-c create getters
    public int getLengthMinutes(){ return lengthMinutes; }
    public int getAgeRating(){ return ageRating; }
    public String getFilmStudio(){ return filmStudio; }

    // 2-c create setters
    public void setLengthMinutes(int lengthMinutes){
        this.lengthMinutes = lengthMinutes; }
    public void setAgeRating(int ageRating){
        this.ageRating = ageRating; }
    public void setFilmStudio(String filmStudio) {
        this.filmStudio = filmStudio; }

    // #3 override methode to calculate value of inventory
    @Override
    public double getInventoryValue(){
        return super.getInventoryValue() * 1.05;
    }

    // #4-a override toString from product class
    @Override
    public  String toString(){
        return  "Item Number      : " + getItemNumber() + "\n" +
                "Name             : " + getName() + "\n" +
                "Movie Length     : " + getLengthMinutes() + "\n" +
                "Age Rating       : " + getAgeRating() +"\n" +
                "Film Studio      : " + getFilmStudio() +"\n" +
                "Quantity in stock: " + getQtyInStock() + "\n" +
                "Price            : " + getPrice() + "\n" +
                "Stock Value      : " + getInventoryValue() + "\n" +
                "Product Status   : " + (isStatus() ? "Active" : "Discontinued") + "\n";
    }
}
