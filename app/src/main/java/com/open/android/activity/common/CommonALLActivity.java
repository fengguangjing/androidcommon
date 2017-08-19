/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午3:05:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.activity.common;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.open.android.R;
import com.open.android.activity.CommonFragmentActivity;
import com.open.android.adapter.common.CommonAllClassAdapter;
import com.open.android.bean.CommonAllBean;

/**
 *****************************************************************************************************************************************************************************
 * 所有类列表
 * @author :fengguangjing
 * @createTime:2017-2-3下午3:05:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class CommonALLActivity extends CommonFragmentActivity implements OnItemClickListener {
	public ListView listview;
	public CommonAllClassAdapter mAllClassAdapter;
	public List<CommonAllBean> list = new ArrayList<CommonAllBean>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.tencenttv.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_all);
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		listview = (ListView) findViewById(R.id.listview);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		try {
			// 这样就能获取ActivityInfo了，之后可以获得Activity的name
			ActivityInfo[] activities = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES).activities;
			list.clear();
			CommonAllBean allBean;
			for (ActivityInfo info : activities) {
				if (!CommonALLActivity.class.getName().equals(info.name)) {
					allBean = new CommonAllBean(info.name, getResources().getString(info.descriptionRes));
					list.add(allBean);
				}
			}
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mAllClassAdapter = new CommonAllClassAdapter(this, list);
		listview.setAdapter(mAllClassAdapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.tencenttv.BaseFragmentActivity#handlerMessage(android.os.Message
	 * )
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handlerMessage(msg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		listview.setOnItemClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
	 * .AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Log.i(TAG, "listView item" + view.getId() + ";postion=" + (int) id + " ========onItemClick ");
		CommonAllBean bean = list.get((int) id);
		if (bean != null && !CommonALLActivity.class.getName().equals(bean.getClassName())) {
			Intent intent = new Intent();
			intent.setClassName(getPackageName(), bean.getClassName());
			startActivity(intent);
		}
	}

}
