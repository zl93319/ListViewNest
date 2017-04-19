package com.bupa.listviewnest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bupa.listviewnest.R;
import com.bupa.listviewnest.util.NameUitl;
import com.bupa.listviewnest.util.UIUtils;


/**
 * Created by Administrator on 2017/4/13.
 */
public class CrewAdapterSon extends BaseAdapter {

    private final int mCount;
    private final String mType;
    CrewAdapter.IDialogShowListener mListener;

    public CrewAdapterSon(int count, String type, CrewAdapter.IDialogShowListener listener) {
        mCount = count;
        mType = type;
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mCount;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(UIUtils.getContext(), R.layout.crew_item_son, null);
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_type);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.btn = (Button) convertView.findViewById(R.id.button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initData(position, holder);
        return convertView;
    }

    private void initData(int position, ViewHolder holder) {
        switch (mType) {
            case "机长":
                item(position, holder, "主机长", "副机长", NameUitl.getName());
                break;
            case "空姐":
                item(position, holder, "空姐组长", "空姐", NameUitl.getName());
                break;
            case "保安":
                item(position, holder, "保安组长", "保安", NameUitl.getName());
                break;
            case "机务":
                item(position, holder, "机务组长", "机务", NameUitl.getName());
                break;
        }
    }

    private void item(final int position, ViewHolder holder, String type, String typeF, String name) {
        if (position == 0) {
            holder.tvType.setText(type);
            holder.tvName.setText(name);
        } else {
            holder.tvType.setText(typeF);
            holder.tvName.setText(name);
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.show();
                }
            }
        });
    }

    static class ViewHolder {
        TextView tvType, tvName;
        Button btn;
    }
}
