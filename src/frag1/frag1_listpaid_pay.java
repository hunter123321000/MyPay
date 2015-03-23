package frag1;

import tw.com.mypay.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class frag1_listpaid_pay extends Activity {

	private Button btn_pay_now, btn_pay_later, btn_title_left;
	private TextView lb_total_account;
	BTN_Click btn_click;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 注意順序
		setContentView(R.layout.frag1_listpaid_pay);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
		setView();
	}

	private void setView() {
		btn_pay_now = (Button) findViewById(R.id.btn_pay_now);
		btn_pay_later = (Button) findViewById(R.id.btn_pay_later);
		btn_title_left = (Button) findViewById(R.id.btn_title_left);
		btn_title_left.setVisibility(View.VISIBLE);
		btn_title_left.setText(getResources().getString(R.string.btn_back));
		lb_total_account = (TextView) findViewById(R.id.lb_total_account);

		btn_click = new BTN_Click();
		btn_pay_now.setOnClickListener(btn_click);
		btn_pay_later.setOnClickListener(btn_click);
		btn_title_left.setOnClickListener(btn_click);
		// init data
		Bundle bundle = this.getIntent().getExtras();		
		lb_total_account.setText(bundle.getString("consume_account"));
	}

	class BTN_Click implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_pay_now://即時線上付款
				Intent i = new Intent();
				Bundle bundle=new Bundle();
				i.setClass(frag1_listpaid_pay.this, frag1_listpaid_pay_now.class);
				bundle.putString("consume_account", lb_total_account.getText().toString());
				i.putExtras(bundle);
				startActivity(i);
				break;
			case R.id.btn_pay_later://稍後自行付款
				i = new Intent();
				bundle=new Bundle();
				i.setClass(frag1_listpaid_pay.this, frag1_listpaid_pay_later.class);
				bundle.putString("consume_account", lb_total_account.getText().toString());
				i.putExtras(bundle);
				startActivity(i);
				break;
			case R.id.btn_title_left:

				break;
			}
		}
	}
}
