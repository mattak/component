![logo](./art/logo_horizontal_small.png)

Divide your Android Activity/Fragment life cycle logic into reusable small components.

# Why?

Activity can easily become a huge code base (I call it Fat Activity).
Because there are so many life cycle related logics, such as google api client, advertising sdk, push sdk and so on.
Many of these libraries just require life cycle event and Activity instance, and it doesn't need to be implemented inside Activity.
In the worst case, the logic requires specific Activity extension which easily conflict with any other libraries.
To avoid the problem - Activity is the bottleneck of implementation, component was created.

Component pattern was introduced by [Game Programming Pattern](http://gameprogrammingpatterns.com/).
And the technique is implemented in Unity3D engine.
This library is heavily inspired by the book and engine.

Component improves:
- Activity/Fragment huge code base.
- Tightly coupled logic in Activity.
- Portability of life cycle related logic.

Component helps you divide application logic of Activity.
Let's say goodbye to Fat Activity by component pattern.

# Install

Import from jcenter.

```
compile "me.mattak:component:0.1.0"
```

# Usage

## 1. Define your component

Implement small pieces of component which you want.
For example, following class just output log on each life cycle.
Generally you don't need to implement all life cycle methods.

```kotlin
class LogComponent : BaseComponent() {
    override fun onCreate(activity: Activity, savedInstanceState: Bundle?) {
        Log.d("Log", "onCreate")
    }

    override fun onStart(activity: Activity) {
        Log.d("Log", "onStart")
    }

    override fun onResume(activity: Activity) {
        Log.d("Log", "onResume")
    }

    override fun onPause(activity: Activity) {
        Log.d("Log", "onPause")
    }

    override fun onStop(activity: Activity) {
        Log.d("Log", "onStop")
    }

    override fun onDestroy(activity: Activity) {
        Log.d("Log", "onDestroy")
    }
}
```

## 2. List up your components

List up components. The order is the same of execution order.

```kotlin
class AppComponents : Components(
        LogComponent(),
        SampleComponent1(),
        SampleComponent2(),
        ...
)
```

## 3. Call your components in Activity

Call component methods on each life cycle

```kotlin
class MainActivity : AppCompatActivity() {
    val component by lazy { AppComponents() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.component.onCreate(this, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        this.component.onStart(this)
    }

    override fun onResume() {
        super.onResume()
        this.component.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        this.component.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        this.component.onStop(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.component.onDestroy(this)
    }
}
```

That's it!
You can keep your Activity simple stupid.

# Examples

- [example](./example)

# LICENSE

[Apache-2.0](./LICENSE.md)
