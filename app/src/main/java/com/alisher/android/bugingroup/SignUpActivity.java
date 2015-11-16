package com.alisher.android.bugingroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText street;
    private Button signUpBtn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        iniToolbar();
        initComponents();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register(){
        ParseUser user = new ParseUser();
        user.setUsername(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        user.put("street", street.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(SignUpActivity.this,"Saving user failed.", Toast.LENGTH_SHORT).show();
                    Log.w("", "Error : " + e.getMessage() + ":::" + e.getCode());
                    if (e.getCode() == 202) {
                        Toast.makeText(SignUpActivity.this,"Username already taken. \n Please choose another username.",Toast.LENGTH_LONG).show();
                        name.setText("");
                        password.setText("");
                        email.setText("");
                        street.setText("");
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "User Saved",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                }
            }
        });
    }

    private void initComponents(){
        name = (EditText) findViewById(R.id.name_register);
        email = (EditText) findViewById(R.id.email_register);
        password = (EditText) findViewById(R.id.password_register);
        street = (EditText) findViewById(R.id.street_register);
        signUpBtn = (Button) findViewById(R.id.register_button);
    }

    private void iniToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
