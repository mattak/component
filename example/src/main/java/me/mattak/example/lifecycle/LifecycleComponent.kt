package me.mattak.example.lifecycle

import android.app.Activity
import android.os.Bundle
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import me.mattak.component.BaseComponent

/**
 * LifecycleComponent
 * Created by mattak on 2017/04/22.
 */
class LifecycleComponent : BaseComponent() {

    val subject: Subject<Lifecycle>  by lazy { PublishSubject.create<Lifecycle>() }

    override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
        super.onCreate(activity, savedInstanceState)
        this.subject.onNext(Lifecycle.onCreate)
    }

    override fun onStart(activity: Activity) {
        super.onStart(activity)
        this.subject.onNext(Lifecycle.onStart)
    }

    override fun onResume(activity: Activity) {
        super.onResume(activity)
        this.subject.onNext(Lifecycle.onResume)
    }

    override fun onPause(activity: Activity) {
        super.onPause(activity)
        this.subject.onNext(Lifecycle.onPause)
    }

    override fun onStop(activity: Activity) {
        super.onStop(activity)
        this.subject.onNext(Lifecycle.onStop)
    }

    override fun onDestroy(activity: Activity) {
        super.onDestroy(activity)
        this.subject.onNext(Lifecycle.onDestroy)
    }
}
