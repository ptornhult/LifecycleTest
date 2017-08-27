package se.codeunlimited.lifecycletest;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;

public abstract class LogFragment extends LifecycleFragment {

    private Timber.Tree getTimber() {
        return Timber.tag(getClass().getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getTimber().d("onCreate");
        super.onCreate(savedInstanceState);
        getTimber().v("onCreated");
    }

    @Override
    public void onDestroy() {
        getTimber().d("onDestroy");
        super.onDestroy();
        getTimber().v("onDestroyed");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getTimber().d("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getTimber().d("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        getTimber().v("onViewCreated");
    }

    @Override
    public void onDestroyView() {
        getTimber().d("onDestroyView");
        super.onDestroyView();
        getTimber().v("onDestroyView");
    }

    @Override
    public void onStart() {
        getTimber().d("onStart");
        super.onStart();
        getTimber().v("onStarted");
    }

    @Override
    public void onStop() {
        getTimber().d("onStop");
        super.onStop();
        getTimber().v("onStopped");
    }

    @Override
    public void onPause() {
        getTimber().d("onPause");
        super.onPause();
        getTimber().v("onPaused");
    }

    @Override
    public void onResume() {
        getTimber().d("onResume");
        super.onResume();
        getTimber().v("onResumed");
    }
}
