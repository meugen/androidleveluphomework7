package ua.meugen.android.levelup.homework7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Scenario1Activity extends AppCompatActivity implements View.OnClickListener {

    private boolean fullActivity = false;

    private ViewGroup root;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        root = (ViewGroup) findViewById(R.id.activity_scenario_1);
    }

    @Override
    public void onClick(final View view) {
        final int viewId = view.getId();
        if (viewId == R.id.button) {
            buttonClicked();
        }
    }

    private void buttonClicked() {
        TransitionManager.beginDelayedTransition(root);

        RelativeLayout.LayoutParams params;
        if (fullActivity) {
            params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
        } else {
            params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            params.removeRule(RelativeLayout.CENTER_IN_PARENT);
        }
        fullActivity = !fullActivity;
        button.setLayoutParams(params);
        button.requestLayout();
    }
}
