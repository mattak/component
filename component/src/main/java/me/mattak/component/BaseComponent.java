package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * BaseComponent
 * Created by mattak on 2017/03/19.
 */
public class BaseComponent implements Component {
    private WeakReference<Components> components;

    @Override
    public void onComponentsAssigned(@NonNull Components components) {
        this.components = new WeakReference<Components>(components);
    }

    @Nullable
    public <T extends Component> T getComponent(@NonNull Class<T> clazz) {
        return this.components.get().getComponent(clazz);
    }

    @NonNull
    public <T extends Component> List<T> getComponents(@NonNull Class<T> clazz) {
        return this.components.get().getComponents(clazz);
    }

    @Override
    public void onCreate(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onStart(@NonNull Activity activity) {
    }

    @Override
    public void onRestart(@NonNull Activity activity) {
    }

    @Override
    public void onResume(@NonNull Activity activity) {
    }

    @Override
    public void onPause(@NonNull Activity activity) {
    }

    @Override
    public void onStop(@NonNull Activity activity) {
    }

    @Override
    public void onDestroy(@NonNull Activity activity) {
    }
}
