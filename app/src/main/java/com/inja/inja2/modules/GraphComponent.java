package com.inja.inja2.modules;

import com.inja.inja2.activities.authentication.FacebookLoginActivity;
import com.inja.inja2.activities.main.MainActivity;
import com.inja.inja2.activities.main.SpotsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sinasix on 6/23/16.
 */
@Singleton
@Component(modules = {NetworkingModules.class})
public interface GraphComponent {
    void inject(MainActivity activity);
    void inject(FacebookLoginActivity activity);
    void inject(SpotsFragment fragment);
}
