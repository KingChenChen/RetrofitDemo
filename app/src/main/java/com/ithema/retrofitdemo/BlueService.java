package com.ithema.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/2/22.
 */

public interface BlueService {
    @GET("book/search")
    Call<String> getSeachBooks(@Query("q")String name,@Query("tag")String tag,
                               @Query("start") String start,@Query("count") int count);
}
//@GET注解就表示get请求，@Query表示请求参数，将会以key = value的方式拼接在url后面