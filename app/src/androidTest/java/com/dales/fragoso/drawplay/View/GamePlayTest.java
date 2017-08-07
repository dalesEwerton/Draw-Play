package com.dales.fragoso.drawplay.View;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.dales.fragoso.drawplay.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class GamePlayTest {

    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);


    @Test
    public void mainMenuActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.playBtn), withText("Iniciar Jogo"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.trollBtn), withText("Troll"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.CadastrarBtn), withText("Cadastrar"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.teamName), isDisplayed()));
        appCompatEditText.perform(replaceText("Joaquim"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.member1), isDisplayed()));
        appCompatEditText2.perform(replaceText("Jose"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.registerFinalyBtn), withText("Casdastrar"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.member2), isDisplayed()));
        appCompatEditText3.perform(replaceText("Xavier"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.registerFinalyBtn), withText("Casdastrar"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.checkBox), withText("Joaquim"), isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.checkBox), withText("Joaquim"), isDisplayed()));
        appCompatCheckBox2.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.CadastrarBtn), withText("Cadastrar"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.registerFinalyBtn), withText("Casdastrar"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.teamName), isDisplayed()));
        appCompatEditText4.perform(replaceText("TeamBest"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.member1), isDisplayed()));
        appCompatEditText5.perform(replaceText("John"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.member2), isDisplayed()));
        appCompatEditText6.perform(replaceText("Dany"), closeSoftKeyboard());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.registerFinalyBtn), withText("Casdastrar"), isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatCheckBox3 = onView(
                allOf(withId(R.id.checkBox), withText("Joaquim"), isDisplayed()));
        appCompatCheckBox3.perform(click());

        ViewInteraction appCompatCheckBox4 = onView(
                allOf(withId(R.id.checkBox2), withText("TeamBest"), isDisplayed()));
        appCompatCheckBox4.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.nextBtn), withText("Selecionar"), isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.feitoBtn), withText("Feito!"),
                        withParent(allOf(withId(R.id.gamePlayLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton10.perform(click());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.feitoBtn), withText("Feito!"),
                        withParent(allOf(withId(R.id.gamePlayLayout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton11.perform(click());

    }

}
