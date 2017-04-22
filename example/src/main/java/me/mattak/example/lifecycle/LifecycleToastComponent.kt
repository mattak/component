package me.mattak.example.lifecycle

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.disposables.Disposable
import me.mattak.component.BaseComponent

/**
 * LifecycleToastComponent
 * Created by mattak on 2017/04/22.
 */
class LifecycleToastComponent : BaseComponent() {
    var disposable: Disposable? = null

    override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
        super.onCreate(activity, savedInstanceState)

        val lifecycle = this.getComponent(LifecycleComponent::class.java) ?: return

        this.disposable = lifecycle.subject
                .filter { it -> it.equals(Lifecycle.onResume) }
                .subscribe { it -> Toast.makeText(activity, "onResume called!!", Toast.LENGTH_SHORT).show() }
    }

    override fun onDestroy(activity: Activity) {
        super.onDestroy(activity)
        this.disposable?.dispose()
    }
}
