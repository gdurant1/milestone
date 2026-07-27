package inventory;

// JP 5 2-d create subclass of product class called DVD
public class CD extends Product {
    // 2-d additional instances
    private String artist;
    private int numberOfSongs;
    private String label;

    // 2-d constructor using super
    public CD (int itemNumber, String name, int QtyInStock, double price,
                String artist, int numberOfSongs, String label){
        super(name, itemNumber, QtyInStock, price);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
        this.label = label;
    }

    // 2-d create getters
    public String getArtist(){ return artist; }
    public int getNumberOfSongs(){ return numberOfSongs; }
    public String getLabel(){ return label; }

    // 2-d create setters
    public void setArtist(String artist){
        this.artist = artist; }
    public void setNumberOfSongs(int numberOfSongs){
        this.numberOfSongs = numberOfSongs; }
    public void setLabel(String label) {
        this.label = label; }

    // 4-b ovveride toString() for CD
    @Override
    public  String toString(){
        return  "Item Number      : " + getItemNumber() + "\n" +
                "Name             : " + getName() + "\n" +
                "Artist           : " + getArtist() +"\n" +
                "Songs on Album   : " + getNumberOfSongs() +"\n" +
                "Record Label     : " + getLabel() +"\n" +
                "Quantity in stock: " + getQtyInStock() + "\n" +
                "Price            : " + getPrice() + "\n" +
                "Stock Value      : " + getInventoryValue() + "\n" +
                "Product Status   : " + (isStatus() ? "Active" : "Discontinued") + "\n";
    }
}
