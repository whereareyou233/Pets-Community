package com.example.pats_community.model;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.pats_community.R;
import com.example.pats_community.model.GetDiscernResultResponse;

import java.util.List;

/**
 * 接受服务器返回数据的类
 * 识别结果列表适配器
 *
 * @author llw
 */
public class DiscernResultAdapter extends BaseQuickAdapter<GetDiscernResultResponse.ResultBean, BaseViewHolder> {
    public DiscernResultAdapter(int layoutResId, @Nullable List<GetDiscernResultResponse.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetDiscernResultResponse.ResultBean item) {
//目前无法返回百度百科的信息，具体错误为访问对象为空
        helper.setText(R.id.tv_keyword, item.getKeyword())
                .setText(R.id.tv_root, item.getRoot());
        /* .setText(R.id.tv_score, String.valueOf(item.getScore())).setText(R.id.tv_baike,item.getBaike_info().getDescription());*/


    }
}