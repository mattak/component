package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Component
 * Created by mattak on 2017/03/19.
 */
public interface Component {
    void onComponentGetterAssigned(@NonNull ComponentGetter getter);

    void onCreate(@NonNull Activity activity, @Nullable Bundle savedInstanceState);

    void onStart(@NonNull Activity activity);

    void onResume(@NonNull Activity activity);

    void onPause(@NonNull Activity activity);

    void onStop(@NonNull Activity activity);

    void onDestroy(@NonNull Activity activity);
}
