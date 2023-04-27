package com.example.myapplication3;

import android.content.Intent;
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

public class Register extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private Button btnRegister;
    private String name, email, password;
    private String URL = "http://192.168.1.10/login/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btne2);


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
                                Toast.makeText(Register.this,"Successfully registered.", Toast.LENGTH_SHORT).show();
                            }
                            else if (response.contains("no")) {
                                Toast.makeText(Register.this, "Something went wrong!", Toast.LENGTH_SHORT).show(); }
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
                    Toast.makeText(Register.this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });
//************************
    }



    public void login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void edite(View view) {
        Bundle b=new Bundle();
        b.putString("y",name);
        b.putString("y2",email);
        b.putString("y3",password);
        Intent i=new Intent(this,Piaf.class);
        i.putExtras(b);
        startActivity(i);


    }
}
/*
 users_table users = new users_table("","","");
                boolean result = myDataBase.insert_users(users);
                if(result)
                    Toast.makeText(this,"insert success",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"insert not success",Toast.LENGTH_LONG).show();
            }*
*/