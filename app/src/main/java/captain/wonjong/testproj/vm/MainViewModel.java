package captain.wonjong.testproj.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import captain.wonjong.testproj.net.ApiClient;
import captain.wonjong.testproj.net.ApiInterface;
import captain.wonjong.testproj.net.res.ExRes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Boolean> viewStatus = new MutableLiveData<>();
    public MutableLiveData<String> responseData = new MutableLiveData<>();

    public void init() {
        ApiClient.getClient().create(ApiInterface.class).exReq().enqueue(mCb);
    }

    public void onMainBtnClick(boolean status) {
        viewStatus.setValue(status);
    }

    Callback mCb = new Callback<ExRes>() {
        @Override
        public void onResponse(Call<ExRes> call, Response<ExRes> response) {
            responseData.setValue(response.body().toString());
        }

        @Override
        public void onFailure(Call<ExRes> call, Throwable t) {

        }
    };
}
