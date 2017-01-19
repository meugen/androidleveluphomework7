package ua.meugen.android.levelup.homework7.first;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Color;
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

import ua.meugen.android.levelup.homework7.R;

public class Scenario1Activity extends AppCompatActivity implements View.OnClickListener {

    private boolean changed = false;

    private ViewGroup root;
    private Button button;

    private ChangeBounds changeBounds;

    private final TimeInterpolator interpolator = new AccelerateInterpolator(2f);
    private final long duration = TimeUnit.SECONDS.toMillis(2);
    private final ValueAnimator.AnimatorUpdateListener textColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(final ValueAnimator animator) {
            final int color = (Integer) animator.getAnimatedValue();
            button.setTextColor(color);
        }
    };
    private final ValueAnimator.AnimatorUpdateListener textSizeUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(final ValueAnimator animator) {
            final float textSize = (Float) animator.getAnimatedValue();
            button.setTextSize(textSize);
        }
    };

    private float smallFontSize;
    private float bigFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        root = (ViewGroup) findViewById(R.id.activity_scenario_1);

        smallFontSize = 20;
        bigFontSize = smallFontSize * 1.2f;
        button.setTextSize(smallFontSize);

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

        ValueAnimator textColorAnimator;
        ValueAnimator textSizeAnimator;

        RelativeLayout.LayoutParams params;
        if (changed) {
            params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            textColorAnimator = ValueAnimator.ofArgb(Color.RED, Color.BLACK);
            textSizeAnimator = ValueAnimator.ofFloat(bigFontSize, smallFontSize);
        } else {
            params = new RelativeLayout.LayoutParams(
                    Math.round(button.getMeasuredWidth() * 1.5f),
                    button.getMeasuredHeight() * 2);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            button.setTextColor(Color.RED);
            button.setTextSize(bigFontSize);
            textColorAnimator = ValueAnimator.ofArgb(Color.BLACK, Color.RED);
            textSizeAnimator = ValueAnimator.ofFloat(smallFontSize, bigFontSize);
        }
        changed = !changed;
        textColorAnimator.addUpdateListener(textColorUpdateListener);
        textColorAnimator.setInterpolator(interpolator);
        textColorAnimator.setDuration(duration);
        textSizeAnimator.addUpdateListener(textSizeUpdateListener);
        textSizeAnimator.setInterpolator(interpolator);
        textSizeAnimator.setDuration(duration);
        button.setLayoutParams(params);
        textColorAnimator.start();
        textSizeAnimator.start();
    }
}
