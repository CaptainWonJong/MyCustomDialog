package captain.wonjong.testproj;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> mBtnText = new MutableLiveData<>();
    public MutableLiveData<Boolean> mIsBtnClick = new MutableLiveData<>();

    public void onMainBtnClick() {
        mIsBtnClick.setValue(true);
    }
}
