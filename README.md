# LifecycleTest
Testing how Android Lifecycle behave in Activities and Fragments

Read the [full article here](https://medium.com/@peter.tornhult/lifecycle-fragments-backstack-f32e34f012d5)

## Test #1 - Activity + LifeCycle
A TextView is shown to the user.
Since counter hasn't been set, the view will display the original text from the layout file.
If the user presses on the screen the counter will update and the view will show the value.
If the activity is destroyed/recreated on orientation change, the view will be updated to the last value of the counter once the activity goes into started state.

## Test #2 - Fragment + Lifecycle
Same as in Test #1 but a Fragment is used instead.

## Test #3 - Fragment + Backstack + Lifecycle
Similar to Test #2, this test also allows the user to load a second Fragment which places the first Fragment on the backstack.
The first Fragment will then be put into stopped state and its view gets destroyed.
Once the second Fragment is popped from the backstack the first Fragment is shown again after its view is recreated.
To get the counter update once the view is created again, we need to observe the counter in onStart instead of onCreate.
Since onStart can be called multiple times (in the application is put in the background then become active again) we must also make sure to unsubscribe onStop so we don't end up with multiple observers.