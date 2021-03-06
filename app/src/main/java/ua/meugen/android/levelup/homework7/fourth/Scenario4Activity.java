package ua.meugen.android.levelup.homework7.fourth;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import ua.meugen.android.levelup.homework7.R;

public class Scenario4Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        image = (ImageView) findViewById(R.id.image);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        final Drawable drawable = image.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
