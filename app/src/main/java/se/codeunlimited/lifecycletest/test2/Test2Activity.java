package se.codeunlimited.lifecycletest.test2;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import se.codeunlimited.lifecycletest.LogActivity;
import se.codeunlimited.lifecycletest.R;

public class Test2Activity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.placeholder, new Test2Fragment());
            fragmentTransaction.commit();
        }
    }
}
