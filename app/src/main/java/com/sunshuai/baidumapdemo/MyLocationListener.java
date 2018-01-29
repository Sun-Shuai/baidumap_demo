package com.sunshuai.baidumapdemo;


import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;

/**
 * Created by sunshuai on 2018/1/29
 */

public class MyLocationListener extends BDAbstractLocationListener {


    private View mView;
    private Result result = new Result();

    MyLocationListener(View view) {
        this.mView = view;
    }

    @Override
    public void onReceiveLocation(BDLocation location) {
        //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
        //以下只列举部分获取地址相关的结果信息
        //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

        result.setAddr(location.getAddrStr());
        result.setCountry(location.getCountry());
        result.setProvince(location.getProvince());
        result.setCity(location.getCity());
        result.setDistrict(location.getDistrict());
        result.setStreet(location.getStreet());

        mView.updateInfo(result);
    }
}
