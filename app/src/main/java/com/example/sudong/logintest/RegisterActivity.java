package com.example.sudong.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private Button closeButton;
    private Button loginButton;
    private Button verificationButton;
    private Button registerButton;

    private EditText phoneNumberET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        closeButton = (Button) findViewById(R.id.button_close);
        closeButton.setOnClickListener(this);
        loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);
        verificationButton = (Button) findViewById(R.id.button_verification);
        verificationButton.setOnClickListener(this);
        registerButton = (Button) findViewById(R.id.button_register);
        registerButton.setOnClickListener(this);

        phoneNumberET = (EditText) findViewById(R.id.et_phone_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_close:
               ActivityCollector.finishAll();
               break;
            case R.id.button_login:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button_verification:
                //设置总时间为60秒，每隔1秒更新一次，对象为verificationButton
                final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(
                        (60 * 1000), 1000, verificationButton);
                myCountDownTimer.start();
                break;
            case R.id.button_register:
                String phoneNumber = phoneNumberET.getText().toString();
                Boolean b = PhoneNumber.verifyPhoneNumber(phoneNumber);
                if (b) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "号码有误", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
