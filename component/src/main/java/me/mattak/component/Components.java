package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Components
 * Created by mattak on 2017/03/19.
 */
public class Components implements Component, ComponentGetter {
    private Component[] components;
    private Map<Class, Component> componentMap;

    public Components(Component... components) {
        this.components = components;
        this.componentMap = this.createMap(this.components);
        this.onComponentGetterAssigned(this);
    }

    private Map<Class, Component> createMap(Component[] components) {
        HashMap<Class, Component> map = new HashMap<Class, Component>();
        for (Component component : components) {
            map.put(component.getClass(), component);
        }
        return map;
    }

    @Override
    public void onComponentGetterAssigned(@NonNull ComponentGetter getter) {
        // assign this object component to derived component
        for (Component component : this.components) {
            component.onComponentGetterAssigned(getter);
        }
    }

    @Override
    public void onCreate(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        for (Component component : this.components) {
            component.onCreate(activity, savedInstanceState);
        }
    }

    @Override
    public void onStart(@NonNull Activity activity) {
        for (Component component : this.components) {
            component.onStart(activity);
        }
    }

    @Override
    public void onResume(@NonNull Activity activity) {
        for (Component component : this.components) {
            component.onResume(activity);
        }
    }

    @Override
    public void onPause(@NonNull Activity activity) {
        for (Component component : this.components) {
            component.onPause(activity);
        }
    }

    @Override
    public void onStop(@NonNull Activity activity) {
        for (Component component : this.components) {
            component.onStop(activity);
        }
    }

    @Override
    public void onDestroy(@NonNull Activity activity) {
        for (Component component : this.components) {
            component.onDestroy(activity);
        }
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(@NonNull Class<T> clazz) {
        if (this.components == null || this.components.length < 1) {
            return null;
        }
        return (T) this.componentMap.get(clazz);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public <T extends Component> List<T> getComponents(@NonNull Class<T> clazz) {
        List<T> list = new ArrayList<T>();

        if (this.components == null || this.components.length < 1) {
            return list;
        }

        for (Component component : this.components) {
            if (component != null && clazz.isAssignableFrom(component.getClass())) {
                list.add((T) component);
            }
        }

        return list;
    }
}
