package function;

public class Talk {

    private String text;
    private int imageHead;
    private String num;

    public int getImageId_1() {
        return imageId_1;
    }

    public int getImageId_2() {
        return imageId_2;
    }

    public int getImageId_3() {
        return imageId_3;
    }

    private int imageId_1;
    private int imageId_2;
    private int imageId_3;
    private String ID;


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


    public int getImageHead() {
        return imageHead;
    }

    public Talk(String text, String ID, int imageId_1, String num, int imageHead, int imageId_2, int imageId_3) {
        this.imageHead = imageHead;
        this.ID = ID;
        this.imageId_1 = imageId_1;
        this.text = text;
        this.num = num;
        this.imageId_2 = imageId_2;
        this.imageId_3 = imageId_3;
    }

}
