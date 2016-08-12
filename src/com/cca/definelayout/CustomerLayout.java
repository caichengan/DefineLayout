package com.cca.definelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @����:com.cca.definelayout
 * @����:CustomerLayout
 * @ʱ��:����9:21:56
 * @author Administrator
 * 
 * @����:�Զ��岼��
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
		// ��ʱtop
		int topmt = 0;
		int parentWidth = getMeasuredWidth();

		// ��ú��Ӹ���
		int count = getChildCount();
		for (int i = 0; i < count; i++)
		{

			// ��ú���ʵ��
			View child = getChildAt(i);
			// ��ú��ӵĸ߶ȡ����
			int childHidth = child.getMeasuredHeight();
			int childWidth = child.getMeasuredWidth();

			if (i % 2 == 0)
			{ // ˫��
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
			{// ����
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
		// invalidate();ˢ��view
		int widthsize = MeasureSpec.getSize(widthMeasureSpec);
		int heightsize = MeasureSpec.getSize(heightMeasureSpec);

		measureChildren(0, 0);// ���ú���
		setMeasuredDimension(widthsize, heightsize);
	}
	//����¼�
	public void switchLayout()
	{
		isRight = !isRight;
		requestLayout();// ˢ�²���
	}
}
