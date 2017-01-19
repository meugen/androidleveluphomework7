package ua.meugen.android.levelup.homework7.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.meugen.android.levelup.homework7.R;

/**
 * @author meugen
 */

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_scenario_2, container, false);
    }
}
