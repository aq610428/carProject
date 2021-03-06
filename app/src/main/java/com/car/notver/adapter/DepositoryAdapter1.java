package com.car.notver.adapter;

import android.content.Context;
import android.view.View;

import com.car.notver.R;
import com.car.notver.bean.KeepInfo;
import com.car.notver.ui.activity.DepositoryActivity1;
import com.car.notver.util.Utility;

import java.util.List;

/**
 * @author: zt
 * @date: 2020/5/21
 * @name:DepositoryAdapter
 */
public class DepositoryAdapter1 extends AutoRVAdapter {
    private List<KeepInfo> infos;
    private DepositoryActivity1 activity1;

    public DepositoryAdapter1(DepositoryActivity1 activity1, List<KeepInfo> list) {
        super(activity1, list);
        this.infos = list;
        this.activity1=activity1;
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
        vh.getTextView(R.id.text_store).setText(info.getStoreName());
        vh.getImageView(R.id.iv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity1.showDelete(info.getId());
            }
        });
    }

    public void setData(List<KeepInfo> keepInfos) {
        this.infos = keepInfos;
    }
}
