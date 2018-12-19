package captain.wonjong.testproj.net;

import captain.wonjong.testproj.net.res.ExRes;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/api/users/3")
    Call<ExRes> exReq();
}
