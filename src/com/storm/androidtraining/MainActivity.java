package com.storm.androidtraining;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.cst.stormdroid.activity.SDBaseListActivity;
import com.cst.stormdroid.adapter.BaseViewHolder;
import com.cst.stormdroid.adapter.SDBaseArrayAdapter;
import com.cst.stormdroid.utils.toast.ToastUtil;

public class MainActivity extends SDBaseListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setListAdapter(new MainAdapter(this, Arrays.asList(getResources().getStringArray(R.array.main_courses))));

		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String title = (String) getListAdapter().getItem(position);
				String courseId = title.substring(title.indexOf("(") + 1, title.indexOf(")"));

				try {
					Field field = R.array.class.getField("main_courses_" + courseId);

					if (field != null) {
						SubActivity.showSubListActivity(MainActivity.this, title, field.getInt(null));
					}
				} catch (NoSuchFieldException e) {
					ToastUtil.debugToast("没有定义该字符数组:" + "main_courses_" + courseId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private class MainAdapter extends SDBaseArrayAdapter<BaseViewHolder, String> {

		public MainAdapter(Context ctx, List<String> list) {
			super(ctx, list);
		}

		@Override
		public View createConvertView(int position) {
			return mInflator.inflate(R.layout.listitem_default, null);
		}

		@Override
		public BaseViewHolder createViewHolder(int position, View convertView) {
			MainViewHolder holder = new MainViewHolder();
			holder.tvText = (TextView) convertView.findViewById(android.R.id.text1);
			return holder;
		}

		@Override
		public void bindViewActions(int position, BaseViewHolder viewHolder) {
		}

		@Override
		public void setViewContents(int position, BaseViewHolder viewHolder) {
			MainViewHolder holder = (MainViewHolder) viewHolder;
			holder.tvText.setText(getItem(position));
		}

		private class MainViewHolder extends BaseViewHolder {
			public TextView tvText;
		}
	}

}
