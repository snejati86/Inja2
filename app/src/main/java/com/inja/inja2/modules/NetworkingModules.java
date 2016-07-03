package com.inja.inja2.modules;

import android.support.annotation.Nullable;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by sinasix on 6/23/16.
 */
@Module
public class NetworkingModules {

    public NetworkingModules()
    {

    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit()
    {
        return new Retrofit.Builder().baseUrl("http://api.injan.io/").addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public SpotService provideSpotService(Retrofit retrofit)
    {
        return retrofit.create(SpotService.class);
    }

    @Provides
    @Singleton
    public CallbackManager provideCallbackManager()
    {
        return CallbackManager.Factory.create();
    }


}
