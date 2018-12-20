package captain.wonjong.testproj.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import captain.wonjong.testproj.ExRepo;
import captain.wonjong.testproj.R;
import captain.wonjong.testproj.net.ApiClient;
import captain.wonjong.testproj.net.ApiInterface;
import captain.wonjong.testproj.net.res.ExRes;
import captain.wonjong.testproj.util.SingleLiveEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    // Data Change
    public MutableLiveData<Boolean> viewStatus = new MutableLiveData<>();
    public MutableLiveData<String> responseData = new MutableLiveData<>();

    // Network
    private ExRepo mExRepo;
    private LiveData<ExRes> exRes;

    // Button Click -> startActivity
    private SingleLiveEvent<Void> goNavigationAct = new SingleLiveEvent<>();

    // Image
    public MutableLiveData<Object> imageUrl = new MutableLiveData<>();

    public void init() {
        mExRepo = new ExRepo();
        exRes = mExRepo.getExResponse();
        imageUrl.setValue(R.drawable.check_on);
    }

    public LiveData<ExRes> getExRes() {
        return exRes;
    }

    public SingleLiveEvent<Void> getGoNavigationAct() {
        return goNavigationAct;
    }

    public void onMainBtnClick(int status) {
        switch (status) {
            case 0:
                viewStatus.setValue(true);
                break;

            case 1:
                viewStatus.setValue(false);
                break;

            case 2:
                goNavigationAct.setValue(null);
                break;
        }
    }
}
