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

public final class EndGameController {

    private static final int NUMBER_OF_IMAGES = 5;
    private static final EndGameController instance = new EndGameController();
    private static List<ImageSrc> congratImages;
    private static Team teamWinner;

    public EndGameController() {
        this.teamWinner = null;
        this.congratImages = new ArrayList<>();
        setCongratImage();
    }

    public static EndGameController getInstance() {
        return instance;
    }

    public static ImageSrc getRandImage() {
        Random random = new Random();

        return congratImages.get(random.nextInt(NUMBER_OF_IMAGES));
    }

    public static Team getTeamWinner() {
        return teamWinner;
    }

    public static void setTeamWinner(Team tw) {
        teamWinner = tw;
    }

    private static void setCongratImage() {
        congratImages.add(new ImageSrc(R.drawable.congratcaprio, "Congrat cáprio"));
        congratImages.add(new ImageSrc(R.drawable.congratjesus, "Congrat jesus"));
        congratImages.add(new ImageSrc(R.drawable.congratjoker, "Congrat joker"));
        congratImages.add(new ImageSrc(R.drawable.congratpaint, "Congrat paint"));
        congratImages.add(new ImageSrc(R.drawable.babycongrats, "Congrat baby"));
    }
}
