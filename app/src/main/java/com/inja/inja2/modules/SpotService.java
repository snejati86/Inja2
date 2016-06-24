package com.inja.inja2.modules;

import com.inja.inja2.model.InjaSpot;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by sinasix on 6/23/16.
 */
public interface SpotService {

    @GET("spots")
    Call<List<InjaSpot>> getSpots(@QueryMap Map<String,String> options);

}
