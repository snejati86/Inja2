package com.inja.inja2.activities.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;

import com.inja.inja2.InjaApplication;
import com.inja.inja2.R;
import com.inja.inja2.model.InjaSpot;
import com.inja.inja2.modules.SpotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpotsFragment extends Fragment implements OnRefreshListener{

    private static final String TAG = SpotsFragment.class.getSimpleName();

    @BindView(R.id.spots_list)
    RecyclerView injaList;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    InjaListAdapter mAdapter;

    @Inject
    SpotService spotService;

    public SpotsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        InjaApplication.ComponentSingleton.getGraphComponent().inject(this);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        injaList.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        injaList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<InjaSpot> spots = new ArrayList<>();


        mAdapter = new InjaListAdapter(spots);
        injaList.setAdapter(mAdapter);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setDistanceToTriggerSync(30);
        Map<String,String> map = new HashMap<>();
        spotService.getSpots(map, AccessToken.getCurrentAccessToken().getToken()).enqueue(new Callback<List<InjaSpot>>() {
            @Override
            public void onResponse(Call<List<InjaSpot>> call, Response<List<InjaSpot>> response) {
                Log.d(TAG,"Got response");
            }

            @Override
            public void onFailure(Call<List<InjaSpot>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

    }

    @Override
    public void onRefresh() {
        Log.d(TAG,"Swiped");
    }
}
