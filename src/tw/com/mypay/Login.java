package tw.com.mypay;

import tabhost.MainTabActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Login extends Activity {

	private EditText et_userid, et_userpwd;
	private Button btn_login;
	private ImageView img_title;
	BTN_Click btn_click;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // ª`·N¶¶§Ç
		setContentView(R.layout.login);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
		setView();
	}

	private void setView() {
		et_userid = (EditText) findViewById(R.id.et_userid);
		et_userpwd = (EditText) findViewById(R.id.et_userpwd);
		btn_login = (Button) findViewById(R.id.btn_login);				
		img_title=(ImageView)findViewById(R.id.img_title);		
		
		btn_click = new BTN_Click();
		btn_login.setOnClickListener(btn_click);
	}

	class BTN_Click implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_login:
				Intent i = new Intent();
				i.setClass(Login.this, MainTabActivity.class);
				startActivity(i);
				finish();
				break;
			}
		}
	}
}
