package com.example.ejer_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_num1,et_num2;
    private Spinner sp_opcion;
    private Button btn_calcular;
    private TextView tv_resul;
    private Double resul=0.0;
    //
    private Button btn_enviar,checkbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num1=(EditText) findViewById(R.id.et_num1);
        et_num2=(EditText) findViewById(R.id.et_num2);
        //
        sp_opcion=(Spinner)findViewById(R.id.spinner);
        //
        btn_calcular=(Button) findViewById(R.id.btn_calcular);
        //
        tv_resul=(TextView) findViewById(R.id.tv_resul);
        //
        btn_enviar= findViewById(R.id.btn_enviar);
        checkbox1 = findViewById(R.id.checkbox1);
        //
        String opcion[]={"sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opcion);
        //R.layout.spiner_item
        sp_opcion.setAdapter(adaptador);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();

            }
        });

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar();
            }
        });
        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( MainActivity.this,Checkboxes_operaciones.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void calcular(){
        String s_num1=et_num1.getText().toString();
        String s_num2=et_num2.getText().toString();
        if(s_num1.isEmpty()||s_num2.isEmpty()){
            Toast.makeText(this, "Ingrese número 1 o numero 2", Toast.LENGTH_SHORT).show();
        }else{
            Double d_num1=Double.parseDouble(s_num1);
            Double d_num2=Double.parseDouble(s_num2);
            String operador= sp_opcion.getSelectedItem().toString();
            if(operador=="sumar"){
                resul=d_num1+d_num2;
            }if(operador=="restar"){
                resul=d_num1-d_num2;
            }if(operador=="multiplicar"){
                resul=d_num1*d_num2;
            }if(operador=="dividir"){
                    resul=d_num1/d_num2;

            }
            tv_resul.setText(resul.toString());

        }
    }
    private  void enviar(){
        Intent enviar= new Intent(MainActivity.this,captura.class);
        enviar.putExtra("dato",tv_resul.getText().toString());

        startActivity(enviar);


    }
}