package ua.meugen.android.levelup.homework7.third;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import ua.meugen.android.levelup.homework7.R;

public class Scenario3ActivityNext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_3_next);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
