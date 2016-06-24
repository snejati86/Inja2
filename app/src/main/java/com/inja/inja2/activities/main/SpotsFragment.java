package com.inja.inja2.activities.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inja.inja2.InjaApplication;
import com.inja.inja2.R;
import com.inja.inja2.model.InjaSpot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpotsFragment extends Fragment {

    @BindView(R.id.spots_list)
    RecyclerView injaList;

    InjaListAdapter mAdapter;


    public SpotsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        injaList.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        injaList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<InjaSpot> spots = new ArrayList<>();
        spots.add(new InjaSpot("Boba",10));
        spots.add(new InjaSpot("YASSca",20));

        mAdapter = new InjaListAdapter(spots);
        injaList.setAdapter(mAdapter);
        super.onViewCreated(view, savedInstanceState);
    }
}
