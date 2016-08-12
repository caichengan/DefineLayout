package com.cca.definelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @包名:com.cca.definelayout
 * @类名:CustomerLayout
 * @时间:上午9:21:56
 * @author Administrator
 * 
 * @描述:自定义布局
 */
public class CustomerLayout extends ViewGroup
{
	private boolean	isRight	= false;

	public CustomerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomerLayout(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		// 临时top
		int topmt = 0;
		int parentWidth = getMeasuredWidth();

		// 获得孩子个数
		int count = getChildCount();
		for (int i = 0; i < count; i++)
		{

			// 获得孩子实例
			View child = getChildAt(i);
			// 获得孩子的高度、宽度
			int childHidth = child.getMeasuredHeight();
			int childWidth = child.getMeasuredWidth();

			if (i % 2 == 0)
			{ // 双行
				if (isRight)
				{
					int left = parentWidth - childWidth;
					int top = topmt;
					int right = left + childWidth;
					int bottom = top + childHidth;
					child.layout(left, top, right, bottom);
				}
				else
				{

					int left = 0;
					int top = topmt;
					int right = left + childWidth;
					int bottom = top + childHidth;
					child.layout(left, top, right, bottom);
				}
			}
			else
			{// 单行
				if (isRight)
				{

					int left = 0;
					int top = topmt;
					int right = left + childWidth;
					int bottom = top + childHidth;
					child.layout(left, top, right, bottom);
				}
				else
				{

					int left = parentWidth - childWidth;
					int top = topmt;
					int right = left + childWidth;
					int bottom = top + childHidth;
					child.layout(left, top, right, bottom);
				}
			}
			topmt += childHidth;
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// invalidate();刷新view
		int widthsize = MeasureSpec.getSize(widthMeasureSpec);
		int heightsize = MeasureSpec.getSize(heightMeasureSpec);

		measureChildren(0, 0);// 设置孩子
		setMeasuredDimension(widthsize, heightsize);
	}
	//点击事件
	public void switchLayout()
	{
		isRight = !isRight;
		requestLayout();// 刷新布局
	}
}
