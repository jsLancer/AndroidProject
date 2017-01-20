package com.example.firstcode.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lancer on 2017/1/16.
 */

public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        if(activity != null){
            activities.add(activity);
        }
    }

    public static void removeActivity(Activity activity){
        if(activity != null){
            activities.remove(activity);
        }
    }

    public static void finishAll() {
        for(Activity activity : activities) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
