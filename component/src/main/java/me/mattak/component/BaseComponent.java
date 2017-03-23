package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * BaseComponent
 * Created by mattak on 2017/03/19.
 */
public class BaseComponent implements Component {
    private WeakReference<Components> components;

    @Override
    public void onComponentsAssigned(Components components) {
        this.components = new WeakReference<Components>(components);
    }

    public <T extends Component> T getComponent(Class<T> clazz) {
        return this.components.get().getComponent(clazz);
    }

    public <T extends Component> List<T> getComponents(Class<T> clazz) {
        return this.components.get().getComponents(clazz);
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onStart(Activity activity) {
    }

    @Override
    public void onRestart(Activity activity) {
    } 
    @Override
    public void onResume(Activity activity) {
    }

    @Override
    public void onPause(Activity activity) {
    }

    @Override
    public void onStop(Activity activity) {
    }

    @Override
    public void onDestroy(Activity activity) {
    }
}
