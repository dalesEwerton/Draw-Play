package com.dales.fragoso.drawplay.Controller;

import com.dales.fragoso.drawplay.Model.Dificulty;

/**
 * Created by dales on 30/07/2017.
 */

public class DificultyController {

    private static Dificulty dificulty;
    private static DificultyController dificultyInstance;

    private DificultyController() {
        dificulty = Dificulty.FACIL;
    }

    public static synchronized DificultyController getDificultyInstance() {
        if(dificultyInstance == null) {
            dificultyInstance = new DificultyController();
        }

        return dificultyInstance;
    }

    public void setDificulty(Dificulty dificulty) {
        this.dificulty = dificulty;
    }
}
