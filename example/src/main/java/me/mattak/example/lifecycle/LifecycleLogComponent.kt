package me.mattak.example.lifecycle

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.ReplaySubject
import me.mattak.component.BaseComponent

/**
 * LifecycleLogComponent
 * Created by mattak on 2017/04/22.
 */
class LifecycleLogComponent : BaseComponent() {
    val value by lazy { ReplaySubject.create<Lifecycle>() }
    var disposable: Disposable? = null

    override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
        super.onCreate(activity, savedInstanceState)

        val lifecycle = this.getComponent(LifecycleComponent::class.java) ?: return
        lifecycle.subject.subscribe(this.value)

        val textView = activity.findViewById(R.id.content) as TextView
        textView.text = ""
        this.disposable = this.value
                .subscribe({ it -> textView.text = textView.text.toString() + it.name + "\n" })
    }

    override fun onDestroy(activity: Activity) {
        super.onDestroy(activity)
        this.disposable?.dispose()
    }
}