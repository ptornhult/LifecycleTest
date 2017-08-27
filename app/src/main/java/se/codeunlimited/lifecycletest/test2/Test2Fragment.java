package se.codeunlimited.lifecycletest.test2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import se.codeunlimited.lifecycletest.LogFragment;
import se.codeunlimited.lifecycletest.R;
import timber.log.Timber;

public class Test2Fragment extends LogFragment {
    private Unbinder unbinder;

    private Test2ViewModel test2ViewModel;
    @BindView(R.id.content) View content;
    @BindView(R.id.text) TextView text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        test2ViewModel = ViewModelProviders.of(this).get(Test2ViewModel.class);
        test2ViewModel.getCounter().observe(this, this::onCounterUpdate);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        content.setOnClickListener(v -> test2ViewModel.incCounter());

    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    private void onCounterUpdate(Integer val) {
        Timber.i("Counter value: %d", val);
        text.setText(getString(R.string.count, val));
    }
}
