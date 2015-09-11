package com.example.kotchaphan.androidlifecycle;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnSignUp;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edtUserName);
        password = (EditText) findViewById(R.id.edtPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertMysql().execute("http://192.168.13.1/trainning/");
            }
        });
    }

    public class InsertMysql extends AsyncTask<String, Void, Void> {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pre processs
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            OkHttpClient client = new OkHttpClient();

            RequestBody body = new FormEncodingBuilder()
                    .add("username", user)
                    .add("password", pass)
                    .build();
            try {
                Request request = new Request.Builder().url(params[0]).post(body).build();

                Response response = client.newCall(request).execute();
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.cancel();
        }
    }
}
