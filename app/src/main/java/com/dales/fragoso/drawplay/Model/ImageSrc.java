package com.dales.fragoso.drawplay.Model;

/**
 * Created by dales on 03/08/2017.
 */

public class ImageSrc {

    private int drawableNum;
    private String imageName;

    public ImageSrc(int drawableNum, String imageName) {
        this.drawableNum = drawableNum;
        this.imageName = imageName;
    }

    public int getDrawableNum() {
        return drawableNum;
    }

    public void setDrawableNum(int drawableNum) {
        this.drawableNum = drawableNum;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
