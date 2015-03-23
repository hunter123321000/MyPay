package frag1;

import tw.com.mypay.R;
import android.app.Activity;
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

public class frag1_listpaid_pay_later extends Activity {

	private Button btn_title_left,btn_send_pay_info_email,btn_send_pay_info_phone,btn_send_pay_info_qrcode;
	private TextView lb_total_account;
	BTN_Click btn_click;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 注意順序
		setContentView(R.layout.frag1_listpaid_pay_later);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
		setView();
	}

	private void setView() {		
		btn_send_pay_info_email= (Button) findViewById(R.id.btn_send_pay_info_email);
		btn_send_pay_info_phone= (Button) findViewById(R.id.btn_send_pay_info_phone);
		btn_send_pay_info_qrcode= (Button) findViewById(R.id.btn_send_pay_info_qrcode);
		
		btn_title_left = (Button) findViewById(R.id.btn_title_left);
		btn_title_left.setVisibility(View.VISIBLE);
		btn_title_left.setText(getResources().getString(R.string.btn_back));
		lb_total_account = (TextView) findViewById(R.id.lb_total_account);

		btn_click = new BTN_Click();		
		btn_title_left.setOnClickListener(btn_click);
		btn_send_pay_info_email.setOnClickListener(btn_click);
		btn_send_pay_info_phone.setOnClickListener(btn_click);
		btn_send_pay_info_qrcode.setOnClickListener(btn_click);
		// init data
		Bundle bundle = this.getIntent().getExtras();
		lb_total_account.setText(bundle.getString("consume_account"));
	}

	class BTN_Click implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {			
			case R.id.btn_title_left:
				break;
			case R.id.btn_send_pay_info_email://發送至消費者電子信箱
				break;
			case R.id.btn_send_pay_info_phone://發送至消費者手機簡訊
				break;
			case R.id.btn_send_pay_info_qrcode://產生QR Code
				break;
				
			}
		}
	}
}
