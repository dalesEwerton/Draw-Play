package com.dales.fragoso.drawplay.Controller;

import com.dales.fragoso.drawplay.Model.Dificulty;

/**
 * Created by dales on 30/07/2017.
 */

public final class DificultyController {

    private static Dificulty dificulty = Dificulty.FACIL;
    private static final DificultyController dificultyInstance = new DificultyController();

    private DificultyController() {
    }

    public static DificultyController getInstance() {
        return dificultyInstance;
    }

    public static void setDificulty(Dificulty dif) {
        dificulty = dif;
    }

    public static Dificulty getDificulty() {
        return dificulty;
    }
}
