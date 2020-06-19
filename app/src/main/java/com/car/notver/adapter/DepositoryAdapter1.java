package com.car.notver.adapter;

import android.content.Context;

import com.car.notver.R;
import com.car.notver.bean.KeepInfo;
import com.car.notver.util.Utility;

import java.util.List;

/**
 * @author: zt
 * @date: 2020/5/21
 * @name:DepositoryAdapter
 */
public class DepositoryAdapter1 extends AutoRVAdapter {
    private List<KeepInfo> infos;

    public DepositoryAdapter1(Context context, List<KeepInfo> list) {
        super(context, list);
        this.infos = list;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_depository1;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {
        KeepInfo info = infos.get(position);
        if (!Utility.isEmpty(info.getNickname())) {
            vh.getTextView(R.id.text_name).setText(info.getNickname() + "");
        } else {
            vh.getTextView(R.id.text_name).setText("匿名");
        }

        vh.getTextView(R.id.text_phone).setText(info.getMobile());
        vh.getTextView(R.id.text_store).setText(info.getMobile());

    }

    public void setData(List<KeepInfo> keepInfos) {
        this.infos = keepInfos;
    }
}
