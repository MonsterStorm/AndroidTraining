package com.storm.androidtraining.C000;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import com.cst.stormdroid.utils.toast.ToastUtil;
import com.storm.androidtraining.uitl.MyPrinter;

public class C00001View extends TextView {
	private static final String TAG = "--" + C00001View.class.getSimpleName();
	private EditText edit;

	public void setEdit(EditText edit) {
		this.edit = edit;
	}

	public C00001View(Context context) {
		super(context);
	}

	public C00001View(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		ToastUtil.debugToast(TAG + ".onMeasure");
		MyPrinter.println(TAG + ".onMeasure", edit);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	public void layout(int l, int t, int r, int b) {
		ToastUtil.debugToast(TAG + ".layout");
		MyPrinter.println(TAG + ".layout", edit);
		super.layout(l, t, r, b);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		ToastUtil.debugToast(TAG + ".onLayout");
		MyPrinter.println(TAG + ".onLayout", edit);
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		ToastUtil.debugToast(TAG + ".onDraw");
		MyPrinter.println(TAG + ".onDraw", edit);
		super.onDraw(canvas);
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		MyPrinter.println(TAG + ".dispatchDraw", edit);
		super.dispatchDraw(canvas);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		ToastUtil.debugToast(TAG + ".onSizeChanged");
		MyPrinter.println(TAG + ".onSizeChanged", edit);
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	public void draw(Canvas canvas) {
		ToastUtil.debugToast(TAG + ".draw");
		MyPrinter.println(TAG + ".draw", edit);
		super.draw(canvas);
	}

}
