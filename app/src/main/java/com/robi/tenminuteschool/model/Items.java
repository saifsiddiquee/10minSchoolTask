package com.robi.tenminuteschool.model;

import java.util.List;

public class Items {
    String heading;
    int image;
    List<ItemSub> itemSubs;

    public Items(String heading, int image, List<ItemSub> itemSubs) {
        this.heading = heading;
        this.image = image;
        this.itemSubs = itemSubs;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<ItemSub> getItemSubs() {
        return itemSubs;
    }

    public void setItemSubs(List<ItemSub> itemSubs) {
        this.itemSubs = itemSubs;
    }
}
