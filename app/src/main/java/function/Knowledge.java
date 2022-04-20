package function;

public class Knowledge {

    private int picture;
    private String contentX;
    private String contentx;
    private int imageId;
    private String text;

    public Knowledge(int picture, String contentX,String contentx,int imageId,String text) {
        this.picture = picture;
        this.contentX = contentX;
        this.imageId = imageId;
        this.text = text;
        this.contentx = contentx;
    }

    public int getPicture() {
        return picture;
    }

    public String getContentX() {
        return contentX;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public String getContentx() {
        return contentx;
    }
}
