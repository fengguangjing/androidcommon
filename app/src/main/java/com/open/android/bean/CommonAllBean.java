/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午11:07:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.bean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午11:07:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class CommonAllBean extends CommonBean{
	public CommonAllBean(String className, String functionDesp) {
		super();
		this.className = className;
		this.functionDesp = functionDesp;
	}

	private String className;
	private String functionDesp;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFunctionDesp() {
		return functionDesp;
	}

	public void setFunctionDesp(String functionDesp) {
		this.functionDesp = functionDesp;
	}
}
