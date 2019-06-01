package android.example.instaeventsv1;

public class Sport {
    //Member variables representing the title and information about the sport
    private String title;
    private String info;

    //will contain the drawable resource
    private final int imageResource;

    /**
     * Constructor for the Sport data model
     * @param title The name of the sport.
     * @param info Information about the sport.
     */
    public Sport(String title, String info , int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }
    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }
    /**
     * Gets the imageResource
     * @return The imageResource
     */
    public int getImageResource(){
        return imageResource;
    }
}
