package se.codeunlimited.lifecycletest.test3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.codeunlimited.lifecycletest.LogFragment;
import se.codeunlimited.lifecycletest.R;


public class Test3Fragment2 extends LogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test3_second, container, false);
    }
}
