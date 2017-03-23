package me.mattak.component;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Components
 * Created by mattak on 2017/03/19.
 */
public class Components implements Component {
    private Component[] components;
    private Map<Class, Component> componentMap;

    public Components(Component... components) {
        this.components = components;
        this.componentMap = this.createMap(this.components);
        this.onComponentsAssigned(this);
    }

    private Map<Class, Component> createMap(Component[] components) {
        HashMap<Class, Component> map = new HashMap<Class, Component>();
        for (Component component : components) {
            map.put(component.getClass(), component);
        }
        return map;
    }

    @Override
    public void onComponentsAssigned(Components components) {
        // assign this object component to derived component
        for (Component component : this.components) {
            component.onComponentsAssigned(components);
        }
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        for (Component component : this.components) {
            component.onCreate(activity, savedInstanceState);
        }
    }

    @Override
    public void onStart(Activity activity) {
        for (Component component : this.components) {
            component.onStart(activity);
        }
    }

    @Override
    public void onRestart(Activity activity) {
        for (Component component : this.components) {
            component.onRestart(activity);
        }
    }

    @Override
    public void onResume(Activity activity) {
        for (Component component : this.components) {
            component.onResume(activity);
        }
    }

    @Override
    public void onPause(Activity activity) {
        for (Component component : this.components) {
            component.onPause(activity);
        }
    }

    @Override
    public void onStop(Activity activity) {
        for (Component component : this.components) {
            component.onStop(activity);
        }
    }

    @Override
    public void onDestroy(Activity activity) {
        for (Component component : this.components) {
            component.onDestroy(activity);
        }
    }

    public <T extends Component> T getComponent(Class<T> clazz) {
        if (this.components == null && this.components.length < 1) {
            return null;
        }
        return (T) this.componentMap.get(clazz);
    }

    public <T extends Component> List<T> getComponents(Class<T> clazz) {
        List<T> list = new ArrayList<T>();

        if (this.components == null && this.components.length < 1) {
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
