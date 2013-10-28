package com.storm.androidtraining;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.cst.stormdroid.activity.SDBaseListActivity;
import com.cst.stormdroid.adapter.BaseViewHolder;
import com.cst.stormdroid.adapter.SDBaseArrayAdapter;
import com.cst.stormdroid.utils.intent.IntentUtil;
import com.cst.stormdroid.utils.string.StringUtil;
import com.cst.stormdroid.utils.toast.ToastUtil;
import com.storm.androidtraining.C006.C006Activity;

public class SubActivity extends SDBaseListActivity {
	private TextView tvTitle;
	private String courseId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		tvTitle = (TextView) findViewById(android.R.id.text1);

		String title = getIntent().getStringExtra("title");
		if (StringUtil.isValid(title)) {
			courseId = title.substring(title.indexOf("(") + 1, title.lastIndexOf(")"));
			tvTitle.setText(title);
		}

		int array = getIntent().getIntExtra("array", 0);

		if (array != 0) {
			setListAdapter(new SubAdapter(this, Arrays.asList(getResources().getStringArray(array))));
		}

		bindActions();
	}

	public void bindActions() {
		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String activityName = "C" + courseId + "Activity";
				try {
					Class clazz = Class.forName(SubActivity.class.getPackage().getName() + ".C" + courseId + "." + activityName);
					Intent intent = new IntentUtil.Builder(SubActivity.this, clazz).toIntent();
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
					ToastUtil.debugToast(SubActivity.class.getPackage().getName() + ".C" + courseId + "." + activityName + " 类不存在!");
				}
			}
		});
	}

	public static void showSubListActivity(Context context, String title, int array) {
		IntentUtil.Builder builder = new IntentUtil.Builder(context, SubActivity.class);
		builder.add("title", title);
		builder.add("array", array);
		context.startActivity(builder.toIntent());
	}

	private class SubAdapter extends SDBaseArrayAdapter<BaseViewHolder, String> {

		public SubAdapter(Context ctx, List<String> list) {
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
