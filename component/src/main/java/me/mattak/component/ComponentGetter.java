package me.mattak.component;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * ComponentGetter
 * Created by mattak on 2017/04/22.
 */

public interface ComponentGetter {
    @Nullable
    <T extends Component> T getComponent(@NonNull Class<T> clazz);

    @NonNull
    <T extends Component> List<T> getComponents(@NonNull Class<T> clazz);
}
