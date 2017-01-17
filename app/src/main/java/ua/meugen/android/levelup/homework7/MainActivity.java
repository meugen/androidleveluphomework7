package ua.meugen.android.levelup.homework7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.scenario_1).setOnClickListener(this);
        findViewById(R.id.scenario_2).setOnClickListener(this);
        findViewById(R.id.scenario_3).setOnClickListener(this);
        findViewById(R.id.scenario_4).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        final int viewId = view.getId();
        if (viewId == R.id.scenario_1) {
            startActivity(new Intent(this, Scenario1Activity.class));
        } else if (viewId == R.id.scenario_2) {
            startActivity(new Intent(this, Scenario2Activity.class));
        } else if (viewId == R.id.scenario_3) {
            startActivity(new Intent(this, Scenario3Activity.class));
        } else if (viewId == R.id.scenario_4) {
            startActivity(new Intent(this, Scenario4Activity.class));
        }
    }
}
