/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-8-14下午3:52:51
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.weak;

import java.lang.ref.WeakReference;

import android.os.Handler;
import android.os.Message;

import com.open.android.fragment.BaseV4MVPFragment;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-8-14下午3:52:51
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class WeakReferenceMVPHandler<F extends BaseV4MVPFragment> extends Handler {
	WeakReference<F> weakReferenceHandler;

	public WeakReferenceMVPHandler(F fragment) {
		weakReferenceHandler = new WeakReference<F>(fragment);
	}

	@Override
	public void handleMessage(Message msg) {
		F fragment = weakReferenceHandler.get();
		if (fragment != null && fragment.isVisible() && fragment.getUserVisibleHint()) {
			fragment.handlerMessage(msg);
			super.handleMessage(msg);
		}
	}

}
