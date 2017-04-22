package me.mattak.example.lifecycle

import android.app.Activity
import android.os.Bundle
import me.mattak.component.BaseComponent

/**
 * LifecycleLogComponent
 * Created by mattak on 2017/04/22.
 */
class LifecycleLogComponent : BaseComponent() {
    override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
        super.onCreate(activity, savedInstanceState)

        val lifecycle = this.getComponent(LifecycleComponent::class.java) ?: return

        lifecycle.subject
                .takeUntil { it -> it == Lifecycle.onDestroy  }
                .subscribe({ it -> android.util.Log.d("Log", "Lifecycle is " + it.name) })
    }
}