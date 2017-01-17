package ua.meugen.android.levelup.homework7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Scenario1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
