package me.mattak.example.lifecycle

import me.mattak.component.Components

/**
 * Application ComponentGetter
 * Created by mattak on 2017/04/22.
 */
class AppComponents : Components(
        LifecycleComponent(),
        LifecycleLogComponent(),
        LifecycleToastComponent()
)
