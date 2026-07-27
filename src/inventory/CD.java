package inventory;

// JP 5 2-d create subclass of product class called DVD
public class CD extends Product {
    // 2-d additional instances
    private int artist;
    private int numberOfSongs;
    private String label;

    // 2-d constructor using super
    public CD (int itemNumber, String name, int QtyInStock, double price,
                int artist, int numberOfSongs, String label){
        super(itemNumber, name, QtyInStock, price);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
        this.label = label;
    }

    // 2-d create getters
    public int getArtist(){ return artist; }
    public int getNumberOfSongs(){ return numberOfSongs; }
    public String getLabel(){ return label; }

    // 2-d create setters
    public void setLengthMinutes(){}
    public void setAgeRating(){}
    public void setFilmStudio(){}

}
