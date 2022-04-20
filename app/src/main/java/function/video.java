package function;

public class video {

    private String text;
    private int imageHead;
    private String num;
    private int imageId;
    private String ID;

    public int getImageHead() {

        return imageHead;
    }

    public String getText() {
        return text;
    }

    public String gettext() {
        return text;
    }
    public String getID() {
        return ID;
    }

    public String getNum() {
        return num;
    }

    public int getImageId() {
        return imageId;
    }


    public video(String text, String ID, int imageId, String num,int imageHead) {
        this.imageHead=imageHead;
        this.ID = ID;
        this.imageId = imageId;
        this.text = text;
        this.num = num;

    }
}
