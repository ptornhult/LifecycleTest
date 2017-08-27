package se.codeunlimited.lifecycletest.test1;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import se.codeunlimited.lifecycletest.LogActivity;
import se.codeunlimited.lifecycletest.R;
import timber.log.Timber;

public class Test1Activity extends LogActivity {

    @BindView(R.id.text)
    TextView text;

    private Test1ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(Test1ViewModel.class);
        viewModel.getCounter().observe(this, this::onCounterUpdate);
    }

    public void incCounter(View view) {
        viewModel.incCounter();
    }

    private void onCounterUpdate(Integer val) {
        Timber.i("Counter value: %d", val);
        text.setText(getString(R.string.count, val));
    }
}
