package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;

/**
 * Component
 * Created by mattak on 2017/03/19.
 */
public interface Component {
    void onComponentsAssigned(Components components);

    void onCreate(Activity activity, Bundle savedInstanceState);

    void onStart(Activity activity);

    void onRestart(Activity activity);

    void onResume(Activity activity);

    void onPause(Activity activity);

    void onStop(Activity activity);

    void onDestroy(Activity activity);
}
