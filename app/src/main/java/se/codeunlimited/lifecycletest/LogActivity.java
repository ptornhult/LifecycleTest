package se.codeunlimited.lifecycletest;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;

import timber.log.Timber;

public abstract class LogActivity extends LifecycleActivity {

    private Timber.Tree getTimber() {
        return Timber.tag(getClass().getSimpleName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTimber().d("onCreate");
        super.onCreate(savedInstanceState);
        getTimber().v("onCreated");
    }

    @Override
    protected void onDestroy() {
        getTimber().d("onDestroy");
        super.onDestroy();
        getTimber().v("onDestroyed");
    }

    @Override
    protected void onStart() {
        getTimber().d("onStart");
        super.onStart();
        getTimber().v("onStarted");
    }

    @Override
    protected void onStop() {
        getTimber().d("onStop");
        super.onStop();
        getTimber().v("onStopped");
    }

    @Override
    protected void onPause() {
        getTimber().d("onPause");
        super.onPause();
        getTimber().v("onPaused");
    }

    @Override
    protected void onResume() {
        getTimber().d("onResume");
        super.onResume();
        getTimber().v("onResumed");
    }
}
