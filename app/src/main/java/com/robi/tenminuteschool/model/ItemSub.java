package com.robi.tenminuteschool.model;

public class ItemSub {
    String heading;
    String caption;
    int image;

    public ItemSub(String heading, String caption, int image) {
        this.heading = heading;
        this.caption = caption;
        this.image = image;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
