package se.codeunlimited.lifecycletest.test1;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import timber.log.Timber;


public class Test1ViewModel extends ViewModel {
    private final MutableLiveData<Integer> counter = new MutableLiveData<>();

    public Test1ViewModel() {
        Timber.d("constructor");
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public void incCounter() {
        Integer value = counter.getValue();
        counter.setValue(value != null ? (value + 1) : 1);
    }

    @Override
    protected void onCleared() {
        Timber.d("onCleared");
        super.onCleared();
    }
}
