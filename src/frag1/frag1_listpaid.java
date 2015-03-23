package frag1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tw.com.mypay.Login;
import tw.com.mypay.R;
import tw.com.mypay.function;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class frag1_listpaid extends Activity {
	private ListView lv_product;	
	private Button btn_title_left, btn_title_right,btn_shopping_cart;
	private static TextView tv_account;
	BTN_Click btn_click;
	private static ArrayList<String> aryls_product = new ArrayList<String>();
	private static ArrayList<String> aryls_price = new ArrayList<String>();
	private ProductAdapter adapter;
	static int i_final_account = 0;
	static List<Boolean> mChecked = new ArrayList<Boolean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.frag1_listpaid);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
		setView();
	}

	private void setView() {
		lv_product = (ListView) findViewById(R.id.lv_product);
		btn_shopping_cart = (Button) findViewById(R.id.btn_shopping_cart);
		btn_title_left = (Button) findViewById(R.id.btn_title_left);
		btn_title_right = (Button) findViewById(R.id.btn_title_right);
		tv_account = (TextView) findViewById(R.id.tv_account);
		btn_title_left.setVisibility(View.VISIBLE);
		btn_title_right.setVisibility(View.VISIBLE);
		btn_title_left.setText(getResources().getString(R.string.btn_logout));

		btn_click = new BTN_Click();
		btn_title_left.setOnClickListener(btn_click);
		btn_title_right.setOnClickListener(btn_click);
		btn_shopping_cart.setOnClickListener(btn_click);

		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");
		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");
		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");
		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");
		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");
		aryls_product.add("測試商品1");
		aryls_price.add("$125.00");
		aryls_product.add("測試商品2");
		aryls_price.add("$150.00");
		aryls_product.add("測試商品3");
		aryls_price.add("$175.00");

		adapter = new ProductAdapter(this);
		lv_product.setAdapter(adapter);		
	}

	class BTN_Click implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_title_left:
				Intent i = new Intent();
				i.setClass(frag1_listpaid.this, Login.class);
				startActivity(i);
				finish();
				break;
			case R.id.btn_title_right:// 新增
				break;
			case R.id.btn_shopping_cart:// 購物車
				break;
			}
		}

	}

	public static class ProductAdapter extends BaseAdapter {
		ViewHolder holder = null;
		private Context context;
		private LayoutInflater inflater = null;

		public ProductAdapter(Context context) {
			this.context = context;
			inflater = LayoutInflater.from(context);
			initDate();
		}

		private void initDate() {
			for (int i = 0; i < aryls_product.size(); i++) {
				mChecked.add(false);
			}
		}

		@Override
		public int getCount() {
			return aryls_product.size();
		}

		@Override
		public Object getItem(int position) {
			return aryls_product.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(R.layout.list_item_checkbox,
						null);
				holder.tv_product = (TextView) convertView
						.findViewById(R.id.tv_product);
				holder.tv_price = (TextView) convertView
						.findViewById(R.id.tv_price);
				holder.cb = (CheckBox) convertView.findViewById(R.id.cb);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.tv_product.setText(aryls_product.get(position));
			holder.tv_price.setText(aryls_price.get(position));
			holder.cb.setChecked(mChecked.get(position));

			holder.cb.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					mChecked.set(position, cb.isChecked());
					if (cb.isChecked() == true) {
						mChecked.set(position, true);
						i_final_account = function.ConvertStrToInt(tv_account
								.getText().toString())
								+ function.ConvertStrToInt(aryls_price
										.get(position));
						tv_account.setText("$" + i_final_account + ".00");
					} else {
						mChecked.set(position, false);
						i_final_account = function.ConvertStrToInt(tv_account
								.getText().toString())
								- function.ConvertStrToInt(aryls_price
										.get(position));
						tv_account.setText("$" + i_final_account + ".00");
					}
				}
			});
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {					 
					if (mChecked.get(position) == false) {
						mChecked.set(position, true);						
						i_final_account = function.ConvertStrToInt(tv_account
								.getText().toString())
								+ function.ConvertStrToInt(aryls_price
										.get(position));
						tv_account.setText("$" + i_final_account + ".00");
					} else {
						mChecked.set(position, false);						
						i_final_account = function.ConvertStrToInt(tv_account
								.getText().toString())
								- function.ConvertStrToInt(aryls_price
										.get(position));
						tv_account.setText("$" + i_final_account + ".00");
					}
					notifyDataSetChanged();
				}
			});

			return convertView;
		}

		public static class ViewHolder {
			TextView tv_product, tv_price;
			CheckBox cb;
		}
	}

	@Override
	protected void onDestroy() {		
		mChecked.clear();
		super.onDestroy();
	}
}
