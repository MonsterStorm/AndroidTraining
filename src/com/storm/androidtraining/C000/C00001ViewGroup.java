package com.storm.androidtraining.C000;

import com.storm.androidtraining.uitl.MyPrinter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class C00001ViewGroup extends LinearLayout {
	private static final String TAG = C00001ViewGroup.class.getSimpleName();
	private EditText edit;

	public void setEdit(EditText edit) {
		this.edit = edit;
	}

	public C00001ViewGroup(Context context) {
		super(context);
	}

	public C00001ViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		MyPrinter.println(TAG + ".onSizeChanged", edit);
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
		MyPrinter.println(TAG + ".measureChild", edit);
		super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		MyPrinter.println(TAG + ".onMeasure", edit);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		MyPrinter.println(TAG + ".onLayout", edit);
		super.onLayout(changed, l, t, r, b);
	}

	@Override
	public void draw(Canvas canvas) {
		MyPrinter.println(TAG + ".draw", edit);
		super.draw(canvas);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		MyPrinter.println(TAG + ".onDraw", edit);
		super.onDraw(canvas);
	}

	@Override
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		MyPrinter.println(TAG + ".drawChild", edit);
		return super.drawChild(canvas, child, drawingTime);
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		MyPrinter.println(TAG + ".dispatchDraw", edit);
		super.dispatchDraw(canvas);
	}

}
