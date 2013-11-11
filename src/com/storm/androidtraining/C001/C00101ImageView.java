package com.storm.androidtraining.C001;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;

public class C00101ImageView extends ImageView {
	public static final int ANIM_LENGTH = 800;
	private Scroller mScroller;

	private OnAnimationListener mAnimationListener;

	public interface OnAnimationListener {
		public void onAnimationStart();

		public void onAnimationEnd();
	}

	public C00101ImageView(Context context) {
		super(context);
		init(context);
	}

	public C00101ImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public void setOnAnimationListener(OnAnimationListener mAnimationListener) {
		this.mAnimationListener = mAnimationListener;
	}

	private void init(Context context) {
		mScroller = new Scroller(context, new DecelerateInterpolator());
	}

	@Override
	public void computeScroll() {
		if (mScroller != null) {
			if (mScroller.computeScrollOffset()) {

				int oldX = getScrollX();
				int oldY = getScrollY();

				if (oldX != mScroller.getCurrX() || oldY != mScroller.getCurrY()) {
					scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
				}

				postInvalidate();
			} else {//animation end
				if (mAnimationListener != null) {
					mAnimationListener.onAnimationEnd();
				}
			}
		}
	}

	public void scrollToTop() {
		if (mScroller.isFinished() == false) {
			mScroller.abortAnimation();
		}

		int height = getHeight();

		mScroller.startScroll(0, 0, 0, height, ANIM_LENGTH);
		invalidate();

		if (mAnimationListener != null) {
			mAnimationListener.onAnimationStart();
		}
	}

	public void scrollToBottom() {
		if (mScroller.isFinished() == false) {
			mScroller.abortAnimation();
		}

		int height = getHeight();

		mScroller.startScroll(0, 0, 0, -height, ANIM_LENGTH);
		invalidate();

		if (mAnimationListener != null) {
			mAnimationListener.onAnimationStart();
		}
	}

}
