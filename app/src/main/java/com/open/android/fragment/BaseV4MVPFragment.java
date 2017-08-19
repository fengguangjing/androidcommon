package com.open.android.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.open.android.weak.WeakReferenceMVPHandler;

/**
 * 
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2016-10-28上午10:36:57
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class BaseV4MVPFragment<T,F extends BaseV4MVPFragment> extends Fragment  {
	public static final String TAG = BaseV4MVPFragment.class.getSimpleName();
	public static final String KEY_CONTENT = BaseV4MVPFragment.class.getSimpleName() + ":Content";
	public String mContent = "";
	public WeakReferenceMVPHandler weakReferenceHandler;
	public View view;
	public String url;
	public boolean isVisibleToUser;
	public int pageNo = 1;
	public String title;
	public int position;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
			mContent = savedInstanceState.getString(KEY_CONTENT);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initValues();
		bindEvent();
	}
	 

	public void setFragment(F f) {
		 weakReferenceHandler = new WeakReferenceMVPHandler(f);
	}


	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_CONTENT, mContent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#setUserVisibleHint(boolean)
	 */
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
		super.setUserVisibleHint(isVisibleToUser);
		initUI(isVisibleToUser);
	}
 
	private boolean isFirst = true;

	protected void initUI(final boolean isVisibleToUser) {
		if (weakReferenceHandler != null) {
			weakReferenceHandler.postDelayed(new Runnable() {
				@Override
				public void run() {
					if (getActivity() == null || !isVisibleToUser) {
						initUI(isVisibleToUser);
					} else {
						if(isFirst){
							weakReferenceHandler.sendEmptyMessageDelayed(MESSAGE_HANDLER, 50);
							isFirst = false;
						}else{
							weakReferenceHandler.sendEmptyMessageDelayed(MESSAGE_DEFAULT_POSITION, 50);
						}
						
					}
				}
			}, 200);
		}
	}
	 
 
	/** 刷新 */
	public static final int MESSAGE_HANDLER = 1000;
	/** 请求数据成功 */
	public static final int MESSAGE_HANDLER_COMPLETE = 1001;
	
	/** drop菜单选择 重新刷新数据 */
	public static final int MESSAGE_DROP_HANDLER = 1002;
	
	/** 默认位置 */
	public static final int MESSAGE_DEFAULT_POSITION = 2000;
	
	/** 在适配器里 调用onitemclick事件*/
	public static final int MESSAGE_ADAPTER_CALL_ONITEM = 9000;
	
	/** dropmenu下来菜单选中事件*/
	public static final int MESSAGE_DROP_MENU_ITEM_SELECTED = 10000;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.interfaces.WeakReferenceHandlerMessage#
	 * referenceHandlerMessage(android.os.Message)
	 */
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
	}

	public boolean onBackPressed() {
		return false;
	}

	/**
	 * 绑定事件，在onviewcreate调用
	 */
	public void bindEvent() {

	}
	
	public void initValues() {

	}

}
