package ua.meugen.android.levelup.homework7.second;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import ua.meugen.android.levelup.homework7.R;

public class Scenario2Activity extends AppCompatActivity {

    static final String TAG = "content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentByTag(TAG) == null) {
            manager.beginTransaction()
                    .add(R.id.activity_scenario_2, new FirstFragment(), TAG)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            home();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void home() {
        final FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            NavUtils.navigateUpFromSameTask(this);
        }
    }

    @Override
    public void onBackPressed() {
        home();
    }
}
