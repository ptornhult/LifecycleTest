package se.codeunlimited.lifecycletest.test3;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import se.codeunlimited.lifecycletest.LogFragment;
import se.codeunlimited.lifecycletest.R;
import timber.log.Timber;

public class Test3Fragment1 extends LogFragment {
    private Unbinder unbinder;

    private Test3ViewModel test3ViewModel;
    @BindView(R.id.content) View content;
    @BindView(R.id.text) TextView text;
    @BindView(R.id.button) Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        test3ViewModel = ViewModelProviders.of(getActivity()).get(Test3ViewModel.class);

        // This will not trigger an update after the backstack is popped and this fragment become visible again
        //test3ViewModel.getCounter().observe((LifecycleOwner) getActivity(), this::onCounterUpdate);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test3_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        content.setOnClickListener(v -> test3ViewModel.incCounter());

        button.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.placeholder, new Test3Fragment2());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        test3ViewModel.getCounter().observe(this, this::onCounterUpdate);
    }


    private void onCounterUpdate(Integer val) {
        Timber.i("Counter value: %d", val);
        text.setText(getString(R.string.count, val));
    }
}
