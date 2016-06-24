package com.inja.inja2.modules;

import com.inja.inja2.InjaApplication;
import com.inja.inja2.activities.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by sinasix on 6/23/16.
 */
@Singleton
@Component(modules = {NetworkingModules.class})
public interface GraphComponent {
    void inject(MainActivity application);
}
