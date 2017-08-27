package se.codeunlimited.lifecycletest.test3;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import se.codeunlimited.lifecycletest.LogActivity;
import se.codeunlimited.lifecycletest.R;

public class Test3Activity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.placeholder, new Test3Fragment1());
            fragmentTransaction.commit();
        }
    }
}
