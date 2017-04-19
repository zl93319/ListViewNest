package com.bupa.listviewnest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bupa.listviewnest.R;
import com.bupa.listviewnest.util.ListViewUtil;
import com.bupa.listviewnest.util.UIUtils;


/**
 * Created by Administrator on 2017/4/12.
 */
public class CrewAdapter extends BaseAdapter {

    private ListView mLv_son;
    private String mType;
    private int mCount;
    private final IDialogShowListener mListener;

    public CrewAdapter(IDialogShowListener listener,IShow iShow) {
        mListener = listener;
        mIShow = iShow;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(UIUtils.getContext(), R.layout.crew_item, null);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.num = (TextView) convertView.findViewById(R.id.rsnum);
            holder.fpNum = (TextView) convertView.findViewById(R.id.fpNum);
            holder.tvBtn = (TextView) convertView.findViewById(R.id.tv_show);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        // 点击"操作"跳转
        holder.tvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIShow.show();
            }
        });
        mLv_son = (ListView) convertView.findViewById(R.id.lv_son);
        initData(position, holder);
        return convertView;
    }

    private void initData(int position, ViewHolder holder) {
        switch (position) {
            case 0:
                item(holder,"机长","5","3");
                break;
            case 1:
                item(holder,"空姐","20","5");
                break;
            case 2:
                item(holder,"保安","30","15");
                break;
            case 3:
                item(holder,"机务","10","5");
                break;
        }
    }

    private void item(ViewHolder holder,String type,String num,String fpNum) {
        holder.type.setText(type);
        holder.num.setText(num);
        holder.fpNum.setText(fpNum);
        mCount = Integer.parseInt(holder.num.getText().toString());
        mType = holder.type.getText().toString();
        System.out.println(mCount+"|"+mType);
        mLv_son.setAdapter(new CrewAdapterSon(mCount, mType,mListener));
        ListViewUtil.setListViewHeightBasedOnChildren(mLv_son);
    }


    static class ViewHolder {
        TextView type, num, fpNum,tvBtn;
    }
    IShow mIShow;
    public interface IShow{
        void show();
    }
    public interface IDialogShowListener{
        void show();
    }
}
