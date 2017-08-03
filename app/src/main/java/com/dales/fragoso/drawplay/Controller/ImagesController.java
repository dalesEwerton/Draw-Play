package com.dales.fragoso.drawplay.Controller;

import com.dales.fragoso.drawplay.Model.Dificulty;
import com.dales.fragoso.drawplay.Model.ImageSrc;
import com.dales.fragoso.drawplay.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dales on 03/08/2017.
 */
public class ImagesController {

    public static final int NUM_OF_IMAGES = 5;
    private List<ImageSrc> imageSrcs;


    public ImagesController(Dificulty dificulty) {

        imageSrcs = new ArrayList<>();

        if(dificulty.equals(Dificulty.FACIL)) {
            setEasyImages();

        }else if(dificulty.equals(Dificulty.MEDIO)) {
            setMedImages();

        }else if(dificulty.equals(Dificulty.DIFICIL)) {
            setHardImages();

        }else {
            setTrollImages();
        }
    }

    public ImageSrc getRandImage() {
        Random random = new Random();

        return this.imageSrcs.get(random.nextInt(NUM_OF_IMAGES));
    }

    private void setEasyImages() {
        imageSrcs.add(new ImageSrc(R.drawable.carro, "Carro"));
        imageSrcs.add(new ImageSrc(R.drawable.cavalo, "Cavalo"));
        imageSrcs.add(new ImageSrc(R.drawable.lapis, "Lapis"));
        imageSrcs.add(new ImageSrc(R.drawable.laranja, "Laranja"));
        imageSrcs.add(new ImageSrc(R.drawable.violao, "Violao"));
    }

    private void setMedImages() {
        imageSrcs.add(new ImageSrc(R.drawable.chaleira, "Chaleira"));
        imageSrcs.add(new ImageSrc(R.drawable.foguete, "Foguete"));
        imageSrcs.add(new ImageSrc(R.drawable.notebook, "Notebook"));
        imageSrcs.add(new ImageSrc(R.drawable.pirata, "Pirata"));
        imageSrcs.add(new ImageSrc(R.drawable.portaretrato, "Porta-Retrato"));
    }

    private void setHardImages() {
        imageSrcs.add(new ImageSrc(R.drawable.eiffel, "Torre Eiffel"));
        imageSrcs.add(new ImageSrc(R.drawable.indio, "Indio"));
        imageSrcs.add(new ImageSrc(R.drawable.navio, "Navio"));
        imageSrcs.add(new ImageSrc(R.drawable.rua, "Rua"));
        imageSrcs.add(new ImageSrc(R.drawable.superhero, "Super-Heroi"));
    }

    private void setTrollImages() {
        imageSrcs.add(new ImageSrc(R.drawable.bolsominion, "Bolsominion"));
        imageSrcs.add(new ImageSrc(R.drawable.chimbinhagod, "Chimbinha God of Metal"));
        imageSrcs.add(new ImageSrc(R.drawable.gravidataubate, "Gravida de Taubate"));
        imageSrcs.add(new ImageSrc(R.drawable.luladrao, "Luladrão"));
        imageSrcs.add(new ImageSrc(R.drawable.monalisaemo, "Monalisa Emo"));
    }

}
