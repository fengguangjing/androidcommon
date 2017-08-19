/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2016-11-25下午4:31:25
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.adapter.common;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.R;
import com.open.android.adapter.CommonAdapter;
import com.open.android.bean.CommonAllBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2016-11-25下午4:31:25
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class CommonAllClassAdapter extends CommonAdapter<CommonAllBean> {

	public CommonAllClassAdapter(Context mContext, List<CommonAllBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CommonAllBean bean = (CommonAllBean) getItem(position);
		View view;
		view = LayoutInflater.from(mContext).inflate(R.layout.adapter_common_all_class, null);
		TextView text_name = (TextView) view.findViewById(R.id.text_name);
		text_name.setText(bean.getFunctionDesp());
		return view;
	}

}
