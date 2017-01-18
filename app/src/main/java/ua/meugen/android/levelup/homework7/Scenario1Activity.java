package ua.meugen.android.levelup.homework7;

import android.animation.TimeInterpolator;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.concurrent.TimeUnit;

public class Scenario1Activity extends AppCompatActivity implements View.OnClickListener {

    private boolean changed = false;

    private ViewGroup root;
    private Button button;

    private ChangeBounds changeBounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        root = (ViewGroup) findViewById(R.id.activity_scenario_1);

        final TimeInterpolator interpolator = new AccelerateInterpolator(2f);
        final long duration = TimeUnit.SECONDS.toMillis(2);

        changeBounds = new ChangeBounds();
        changeBounds.addTarget(button);
        changeBounds.setInterpolator(interpolator);
        changeBounds.setDuration(duration);
    }

    @Override
    public void onClick(final View view) {
        final int viewId = view.getId();
        if (viewId == R.id.button) {
            buttonClicked();
        }
    }

    private void buttonClicked() {
        TransitionManager.beginDelayedTransition(root, changeBounds);

        RelativeLayout.LayoutParams params;
        if (changed) {
            params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
        } else {
            params = new RelativeLayout.LayoutParams(
                    Math.round(button.getMeasuredWidth() * 1.5f),
                    button.getMeasuredHeight() * 2);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        }
        changed = !changed;
        button.setLayoutParams(params);
    }
}
