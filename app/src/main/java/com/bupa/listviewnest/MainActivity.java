package com.bupa.listviewnest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bupa.listviewnest.adapter.CrewAdapter;

import cn.carbs.android.library.MDDialog;

public class MainActivity extends AppCompatActivity {

    private MDDialog mMdDialog;
    private ImageView mIvBack;
    private ListView mLvMaintenanceStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listener();
        initData();
    }

    private void initData() {

    }

    private void listener() {
        mLvMaintenanceStaff.setAdapter(new CrewAdapter(new CrewAdapter.IDialogShowListener() {
            // 点击"解聘按钮" 的接口回调
            @Override
            public void show() {
                dialogShow(new String[]{"您确定要解雇该人员么?"}, "确定");
            }
        }, new CrewAdapter.IShow() {
            // 点击"操作按钮" 的接口回调
            @Override
            public void show() {

            }
        }));
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mLvMaintenanceStaff = (ListView) findViewById(R.id.lv_maintenance_staff);
    }
    private void dialogShow(String[] arr, String btnMsg) {
        mMdDialog = new MDDialog.Builder(this)
                .setMessages(arr)
                .setTitle("温馨提示")
                .setIcon(getResources().getDrawable(R.mipmap.over_tb))
                .setPositiveButton(btnMsg, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMdDialog.dismiss();
                    }
                }).create();
        mMdDialog.show();
    }
}
