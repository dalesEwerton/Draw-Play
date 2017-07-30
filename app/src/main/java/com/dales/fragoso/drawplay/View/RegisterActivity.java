package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dales.fragoso.drawplay.Controller.TeamsController;
import com.dales.fragoso.drawplay.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();
    }

    public void registerTeam(View view) {
        EditText teamName = (EditText) findViewById(R.id.teamName);
        EditText member1 = (EditText) findViewById(R.id.member1);
        EditText member2 = (EditText) findViewById(R.id.member2);
        EditText member3 = (EditText) findViewById(R.id.member3);
        EditText member4 = (EditText) findViewById(R.id.member4);
        String[] members = new String[4];

        if(checkEditText(teamName)){
            if(checkEditText(member1) && checkEditText(member2)) {
                members[0] = member1.getText().toString();
                members[1] = member2.getText().toString();

                if(checkEditText(member3)) {
                    members[2] = member3.getText().toString();
                }

                if(checkEditText(member4)) {
                    members[3] = member4.getText().toString();
                }

                TeamsController.getTeamsInstance().addTeam(teamName.getText().toString(), members);
                Intent it = new Intent(RegisterActivity.this, TeamsActivity.class);
                startActivity(it);

            }else {
                Toast noMembers = Toast.makeText(getApplicationContext(), "Numero de membros insuficiente", Toast.LENGTH_LONG);
                noMembers.show();
            }
        }else {
            Toast noTeamName = Toast.makeText(getApplicationContext(), "Defina o nome do time", Toast.LENGTH_LONG);
            noTeamName.show();
        }
    }

    private boolean checkEditText(EditText text) {
        return (text !=  null && !text.getText().toString().equals(""));
    }
}
