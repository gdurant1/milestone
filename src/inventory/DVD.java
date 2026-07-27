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
        super(itemNumber, name, QtyInStock, price);
        this.lengthMinutes = lengthMinutes;
        this.ageRating = ageRating;
        this.filmStudio = filmStudio;
    }
    
}
