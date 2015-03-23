package frag1;

import tw.com.mypay.Login;
import tw.com.mypay.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class frag1_qucikpaid extends Activity {
	private Button btn_title_left, btn_prepaid, btn_singalpaid, btn_pay;
	BTN_Click btn_click;
	private EditText et_customer_info, et_account;
	private Spinner sp_product_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.frag1_quickpaid);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
		setView();		
	}

	private void setView() {
		btn_title_left = (Button) findViewById(R.id.btn_title_left);
		btn_pay = (Button) findViewById(R.id.btn_pay);
		btn_title_left.setVisibility(View.VISIBLE);
		btn_title_left.setText(getResources().getString(R.string.btn_logout));
		et_customer_info = (EditText) findViewById(R.id.et_customer_info);
		et_account = (EditText) findViewById(R.id.et_account);
		sp_product_info = (Spinner) findViewById(R.id.sp_product_info);
		btn_prepaid = (Button) findViewById(R.id.btn_prepaid);
		btn_singalpaid = (Button) findViewById(R.id.btn_singalpaid);

		btn_click = new BTN_Click();
		btn_title_left.setOnClickListener(btn_click);
		btn_pay.setOnClickListener(btn_click);
		btn_prepaid.setOnClickListener(btn_click);
		btn_singalpaid.setOnClickListener(btn_click);

	}

	class BTN_Click implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_title_left:
				Intent i = new Intent();
				i.setClass(frag1_qucikpaid.this, Login.class);
				startActivity(i);
				finish();
				break;
			case R.id.btn_pay:// ¥I´Ú
				i = new Intent();
				Bundle bundle=new Bundle();
				i.setClass(frag1_qucikpaid.this, frag1_listpaid_pay.class);
				bundle.putString("consume_account", et_account.getText().toString());
				i.putExtras(bundle);
				startActivity(i);
				break;
			case R.id.btn_prepaid:// Àx­È¥I´Ú
				sp_product_info.setVisibility(View.VISIBLE);
				et_customer_info.setVisibility(View.GONE);
				break;
			case R.id.btn_singalpaid:// ³æµ§¥I´Ú
				sp_product_info.setVisibility(View.GONE);
				et_customer_info.setVisibility(View.VISIBLE);
				break;
			}
		}

	}
}
