package com.sunshuai.baidumapdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends AppCompatActivity implements View {


    TextView tvAddr;
    TextView tvCountry;
    TextView tvProvince;
    TextView tvCity;
    TextView tvDistrict;
    TextView tvStreet;

    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBaiduMap();

    }

    private void initView() {
        tvAddr = findViewById(R.id.textAddress);
        tvCountry = findViewById(R.id.textCountry);
        tvProvince = findViewById(R.id.textProvince);
        tvCity = findViewById(R.id.textCity);
        tvDistrict = findViewById(R.id.textDistrict);
        tvStreet = findViewById(R.id.textStreet);
    }

    private void initBaiduMap() {
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数

        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);
        //可选，是否需要地址信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的地址信息，此处必须为true

        mLocationClient.setLocOption(option);
        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
        mLocationClient.start();
    }


    @Override
    public void updateInfo(Result result) {
        tvAddr.setText(result.getAddr());
        tvCountry.setText(result.getCountry());
        tvProvince.setText(result.getProvince());
        tvCity.setText(result.getCity());
        tvDistrict.setText(result.getDistrict());
        tvStreet.setText(result.getStreet());
    }
}
