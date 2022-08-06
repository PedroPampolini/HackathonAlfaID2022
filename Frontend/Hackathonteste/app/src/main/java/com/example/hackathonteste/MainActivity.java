package com.example.hackathonteste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    EditText cpf, senha;
    Button logar;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpf = findViewById(R.id.cpf);
        senha = findViewById(R.id.senha);
        logar = findViewById(R.id.logar);
        texto = findViewById(R.id.textoSample);
    }

    public boolean confere(View view){
        boolean rsp = true;
        if(senha.getText().toString().length() < 6){
            rsp = false;
            Toast.makeText(this,"SENHA INVÁLIDA",Toast.LENGTH_LONG).show();
        }
        /*if(validaCPF(cpf.getText().toString()) == false){
            rsp = false;
            Toast.makeText(this,"CPF INVÁLIDO",Toast.LENGTH_LONG).show();
        }*/
        return rsp;
    }

    public static boolean validaCPF(String cpf){
        boolean rsp = false;
        if(cpf.length() >= 11) {
            int[] cpfNum = new int[11];
            int total = 0, primDigito, secDigito;
            //Transforma a string em um vetor de inteiros
            for (int i = 0; i < cpfNum.length; i++) {
                cpfNum[i] = Integer.parseInt("" + cpf.charAt(i));
            }

            //Realiza soma do primeiro digito verificador
            for (int i = 0; i < 9; i++) {
                total += cpfNum[i] * (i + 1);
            }
            total %= 11;
            primDigito = (total == 10) ? 0 : total;

            //Realiza soma do segundo digito verificador
            total = 0;
            for (int i = 0; i < 10; i++) {
                total += cpfNum[i] * i;
            }
            total %= 11;
            secDigito = (total == 10) ? 0 : total;

            rsp = (primDigito == cpfNum[9]) && (secDigito == cpfNum[10]);
        }
        return  rsp;
    }

    public void showAlertDialog(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Login Inválido!");
            alert.setMessage("Senha deve conter no mínimo 6 dígitos");
            alert.setCancelable(false);
    }

    public void login(View view){
        if(confere(view)){
            RequestQueue queue = Volley.newRequestQueue(this);
            String cpfStr = cpf.getText().toString();
            String senhaStr = senha.getText().toString();
            String url = "http://192.168.1.118:3001/login/" + cpfStr + "/" + senhaStr;
            texto.setText("That work ");
            StringRequest sr = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            texto.setText(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    texto.setText("That didn't work " + error.getMessage());
                }
            });

            queue.add(sr);
            Toast.makeText(this,"Tudo certo",Toast.LENGTH_LONG).show();


        }
    }

}