package me.mattak.example.lifecycle

import android.app.Activity
import android.widget.Toast
import me.mattak.component.BaseComponent

/**
 * LifecycleToastComponent
 * Created by mattak on 2017/04/22.
 */
class LifecycleToastComponent : BaseComponent() {
    override fun onStart(activity: Activity) {
        super.onStart(activity)

        val lifecycle = this.getComponent(LifecycleComponent::class.java) ?: return

        lifecycle.subject
                .takeUntil { it -> it.equals(Lifecycle.onDestroy) }
                .filter { it -> it.equals(Lifecycle.onResume) }
                .subscribe { it -> Toast.makeText(activity, "onResume called!!", Toast.LENGTH_SHORT).show() }
    }
}
