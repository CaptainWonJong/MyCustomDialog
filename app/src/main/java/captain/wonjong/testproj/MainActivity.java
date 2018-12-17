 package captain.wonjong.testproj;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import captain.wonjong.testproj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Context             mContext;
    private ActivityMainBinding mMainBinding;
    private MainViewModel       mMainViewModel;

    private MyDialog mDialog;
    private MyDialog mDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainBinding.setVm(mMainViewModel);
        mMainBinding.setLifecycleOwner(this);

        mMainViewModel.mBtnText.setValue("Click!");



        mDialog = MyDialog.getInstance();
        mDialog2 = MyDialog.getInstance();

        mMainViewModel.mIsBtnClick.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                mDialog.showDialog(mContext, "asdfasdf", "asdfasdf", false);

            }
        });
    }
}
