package com.inja.inja2;

import android.app.Application;

import com.inja.inja2.modules.DaggerGraphComponent;
import com.inja.inja2.modules.GraphComponent;

/**
 * Created by sinasix on 6/23/16.
 */
public class InjaApplication extends Application {

    public static class ComponentSingleton{
        private static  GraphComponent graphComponent;
        public static void setComponent(GraphComponent gc){
            graphComponent = gc;
        }

        public static GraphComponent getGraphComponent()
        {
            return graphComponent;
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        ComponentSingleton.setComponent(DaggerGraphComponent.builder().build());
    }
}
