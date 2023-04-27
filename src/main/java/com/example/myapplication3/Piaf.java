package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Piaf extends AppCompatActivity {
    private EditText etName, etEmail, etPassword;
    private Button btnRegister,btnD;
    private String name, email, password;
    private String URL = "http://192.168.1.10/login/register.php";
    private String URL2 = "http://192.168.1.10/login/delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piaf);
        etName = findViewById(R.id.etName2);
        etEmail = findViewById(R.id.etEmail2);
        etPassword = findViewById(R.id.etPassword2);
        /*Bundle b1=getIntent().getExtras();
        name=b1.getString("y");
        email=b1.getString("y2");
        password=b1.getString("y3");
        etName.setText(name);
        etEmail.setText(email);
        etPassword.setText(password);*/
//___________________________________________________

        btnRegister = findViewById(R.id.btne22);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();


                if (!name.equals("") && !email.equals("") && !password.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains("yes")) {
                                Toast.makeText(Piaf.this,"UPDATE registered.", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.contains("no")) {
                                Toast.makeText(Piaf.this, "Something went wrong!", Toast.LENGTH_SHORT).show(); }
                        }


                    },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("name", name);
                            data.put("email", email);
                            data.put("password", password);
                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(Piaf.this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });

//****************************
        btnD = findViewById(R.id.btne0);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();



                if (!name.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL2, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains("yes")) {
                                Toast.makeText(Piaf.this,"Success delete.", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.contains("no")) {
                                Toast.makeText(Piaf.this, "Something went wrong!", Toast.LENGTH_SHORT).show(); }
                        }


                    },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("name", name);

                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(Piaf.this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }
                etName.setText(""); ; etEmail.setText(""); etPassword.setText("");

            }
        });





    }


}
