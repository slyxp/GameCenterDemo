package com.tcl.gamecenter;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements RadioGroup.OnCheckedChangeListener {

    private TabHost mTabHost;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        mTabHost = this.getTabHost();
    }

    private void initData() {
        mTabHost.addTab(mTabHost.newTabSpec("RECOMMEND").setIndicator("RECOMMEND").setContent(new Intent(this, RecommendActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("RANK").setIndicator("RANK").setContent(new Intent(this, RankActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("CATEGORY").setIndicator("CATEGORY").setContent(new Intent(this, CategoryActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("MINE").setIndicator("MINE").setContent(new Intent(this, MineActivity.class)));

        mRadioGroup = (RadioGroup) findViewById(R.id.main_radio);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.radio_button_recommend:
                mTabHost.setCurrentTabByTag("RECOMMEND");
                break;

            case R.id.radio_button_rank:
                mTabHost.setCurrentTabByTag("RANK");
                break;

            case R.id.radio_button_category:
                mTabHost.setCurrentTabByTag("CATEGORY");
                break;

            case R.id.radio_button_mine:
                mTabHost.setCurrentTabByTag("MINE");
                break;

            default:
                break;
        }
    }
}
