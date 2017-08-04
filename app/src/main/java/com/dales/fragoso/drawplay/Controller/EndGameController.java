package com.dales.fragoso.drawplay.Controller;

import android.media.Image;

import com.dales.fragoso.drawplay.Model.ImageSrc;
import com.dales.fragoso.drawplay.Model.Team;
import com.dales.fragoso.drawplay.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dales on 03/08/2017.
 */

public class EndGameController {

    public static final int NUMBER_OF_IMAGES = 5;
    private List<ImageSrc> congratImages;
    private Team teamWinner;

    public EndGameController(Team team) {
        this.teamWinner = team;
        this.congratImages = new ArrayList<>();
        setCongratImage();
    }

    public ImageSrc getRandImage() {
        Random random = new Random();

        return this.congratImages.get(random.nextInt(NUMBER_OF_IMAGES));
    }

    private void setCongratImage() {
        congratImages.add(new ImageSrc(R.drawable.congratcaprio, "Congrat cáprio"));
        congratImages.add(new ImageSrc(R.drawable.congratjesus, "Congrat jesus"));
        congratImages.add(new ImageSrc(R.drawable.congratjoker, "Congrat joker"));
        congratImages.add(new ImageSrc(R.drawable.congratpaint, "Congrat paint"));
        congratImages.add(new ImageSrc(R.drawable.babycongrats, "Congrat baby"));
    }
}
