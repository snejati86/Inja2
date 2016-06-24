package com.inja.inja2.activities.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inja.inja2.R;
import com.inja.inja2.model.InjaSpot;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sinasix on 6/21/16.
 */
public class InjaListAdapter extends RecyclerView.Adapter<InjaListAdapter.ViewHolder>{

    private List<InjaSpot> mList;

    public InjaListAdapter(List<InjaSpot> spots ){
        mList = spots;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.spot_name)
        TextView spotName;

        @BindView(R.id.score)
        TextView score;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inja_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InjaSpot spot = mList.get(position);
        holder.score.setText(String.valueOf(spot.getScore()));
        holder.spotName.setText(spot.getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
