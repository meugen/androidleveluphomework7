package ua.meugen.android.levelup.homework7.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ua.meugen.android.levelup.homework7.R;

/**
 * @author meugen
 */

public class FirstFragment extends Fragment implements View.OnClickListener {

    private View image;
    private View text;

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_first_scenario_2, container, false);
        image = view.findViewById(R.id.image);
        image.setOnClickListener(this);
        text = view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onClick(final View view) {

        final SecondFragment fragment = new SecondFragment();
        fragment.setSharedElementEnterTransition(new ChangeBounds());
        getFragmentManager().beginTransaction()
                .replace(R.id.activity_scenario_2, fragment, Scenario2Activity.TAG)
                .addSharedElement(image, getString(R.string.transition_image_name))
                .addSharedElement(text, getString(R.string.transition_text_name))
                .addToBackStack(null)
                .commit();
    }
}
