package id.ac.poliban.mi.wawa.materialme_resource_053;

class Sport {

    // Member variables representing the title and information about the sport.
    private final String title;
    private final String info;
    private final int imageResource;

    // Constructor for the Sport data model.

    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

     //Gets the title of the sport.

    String getTitle() {
        return title;
    }

    // Gets the info about the sport.
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

}
