package com.storm.androidtraining.C000;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.cst.stormdroid.utils.toast.ToastUtil;
import com.storm.androidtraining.R;
import com.storm.androidtraining.uitl.MyPrinter;

public class C00001Fragment extends SDBaseSupportFragment {
	private EditText edit;
	//View group
	private Button btn1;
	private Button btn2;
	private Button btn3;
	//View
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btnClear;
	private Button btnAddChild;
	private Button btnRemoveChild;
	private C00001ViewGroup mViewGroup;
	private C00001View mView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_c00001, container, false);
		mViewGroup = (C00001ViewGroup) view.findViewById(R.id.c00001ViewGroup);
		btn1 = (Button) view.findViewById(android.R.id.button1);
		btn2 = (Button) view.findViewById(android.R.id.button2);
		btn3 = (Button) view.findViewById(android.R.id.button3);

		btn4 = (Button) view.findViewById(R.id.btn4);
		btn5 = (Button) view.findViewById(R.id.btn5);
		btn6 = (Button) view.findViewById(R.id.btn6);

		btnClear = (Button) view.findViewById(R.id.btnClear);
		btnAddChild = (Button) view.findViewById(R.id.btnAddChild);
		btnRemoveChild = (Button) view.findViewById(R.id.btnRemoveChild);
		edit = (EditText) view.findViewById(android.R.id.edit);
		return view;
	}

	@Override
	protected void initData() {
		super.initData();

		if (mView != null) {
			mView.setEdit(edit);
		}
		mViewGroup.setEdit(edit);
	}

	@Override
	protected void bindActions() {
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mViewGroup.invalidate();
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mViewGroup.requestLayout();
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mViewGroup.requestFocus();
			}
		});

		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mView != null)
					mView.invalidate();
				else
					ToastUtil.debugToast("Add a child first!");
			}
		});
		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mView != null)
					mView.requestLayout();
				else
					ToastUtil.debugToast("Add a child first!");
			}
		});
		btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mView != null)
					mView.requestFocus();
				else
					ToastUtil.debugToast("Add a child first!");
			}
		});

		btnClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MyPrinter.clear(edit);
			}
		});
		btnAddChild.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mView == null) {
					mView = new C00001View(getActivity());
					mView.setBackgroundColor(Color.RED);
					mView.setText("Child View");
					mViewGroup.addView(mView);
					mView.setEdit(edit);
				}
			}
		});
		
		btnRemoveChild.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mView != null){
					mViewGroup.removeAllViews();
					mView = null;
				}
			}
		});
	}
}
