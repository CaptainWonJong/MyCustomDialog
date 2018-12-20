package captain.wonjong.testproj;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import captain.wonjong.testproj.net.ApiClient;
import captain.wonjong.testproj.net.ApiInterface;
import captain.wonjong.testproj.net.res.ExRes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExRepo {
    public LiveData<ExRes> getExResponse() {
        final MutableLiveData<ExRes> data = new MutableLiveData<>();
        ApiClient.getClient().create(ApiInterface.class).exReq().enqueue(new Callback<ExRes>() {
            @Override
            public void onResponse(Call<ExRes> call, Response<ExRes> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ExRes> call, Throwable t) {

            }
        });
        return data;
    }
}
