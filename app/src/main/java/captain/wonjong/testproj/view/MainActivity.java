package captain.wonjong.testproj.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import captain.wonjong.testproj.NavigationActivity;
import captain.wonjong.testproj.R;
import captain.wonjong.testproj.databinding.ActivityMainBinding;
import captain.wonjong.testproj.vm.MainViewModel;


public class MainActivity extends AppCompatActivity {
    private Context             mContext;
    private ActivityMainBinding mMainBinding;
    private MainViewModel       mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainBinding.setVm(mMainViewModel);
        mMainBinding.setLifecycleOwner(this);

        mMainViewModel.init();

        mMainViewModel.getGoNavigationAct().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            }
        });
    }
}
