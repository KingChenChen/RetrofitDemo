package com.ithema.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.textview)
    TextView textview;
    private BlueService blueService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //创建一个Retrofit的实例，并完成相应的配置
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        blueService = retrofit.create(BlueService.class);
    }

    @OnClick(R.id.button)
    public void onClick() {

        //调用请求方法，并得到Call实例
        Call<String> call = blueService.getSeachBooks("小王子", "", "0", 3);
        //使用Call实例完成同步或异步请求
        //异步请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //请求成功的回调方法
                String data = response.body();
                Toast.makeText(MainActivity.this,"网络请求成功!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                //请求失败的回调方法
                Toast.makeText(MainActivity.this,"网络请求失败!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //测试测试测试
    //在GitHub上面进行测试提交
    //我在本地进行修改修改代码的测试，呵呵呵
}
