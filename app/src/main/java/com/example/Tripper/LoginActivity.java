package com.example.Tripper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sharedPreferences = getSharedPreferences(SignUpActivity.EMAIL_KEY, MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        EditText emailEditText = findViewById(R.id.email_editText);
        String email = emailEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.password_editText);
        String password = passwordEditText.getText().toString();


        String userAllowed = retrieveSavedEmail();
        String correctPassword = retrieveSavedPassword();
        if (email.equals(userAllowed) &&
                password.equals(correctPassword)) {
            Button button = findViewById(R.id.login_button);
            Snackbar.make(button,
                    "Logged In!",
                    Snackbar.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.login_error_title);
            d.setMessage(R.string.login_error_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
    }

    private String retrieveSavedEmail() {
        return sharedPreferences.getString(SignUpActivity.EMAIL_KEY, null);
    }

    private String retrieveSavedPassword() {
        return sharedPreferences.getString(SignUpActivity.PASSWORD_KEY, null);
    }


}
