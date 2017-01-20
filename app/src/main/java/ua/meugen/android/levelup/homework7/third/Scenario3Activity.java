package ua.meugen.android.levelup.homework7.third;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ua.meugen.android.levelup.homework7.R;

public class Scenario3Activity extends AppCompatActivity implements View.OnClickListener {

    private View image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        image = findViewById(R.id.image);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        final ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<>(image, getString(R.string.transition_image_name)));
        startActivity(new Intent(this, Scenario3ActivityNext.class), options.toBundle());
    }
}
