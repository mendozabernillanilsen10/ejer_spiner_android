package com.example.ejer_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Checkboxes_operaciones extends AppCompatActivity {
    private EditText num1,num2;
    private CheckBox suma,resta,mult,divi;
    private TextView resultado;
    private Button calcular,btn_productos;
    //varibales
    private String ss_num1,ss_num2,ss_resultado="";
    private Double d_num1,d_num2;
    private Double resul=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkboxes_operaciones);
        num1=(EditText) findViewById(R.id.et_numero1_);
        num2=(EditText) findViewById(R.id.et_numero2_);
        //
        suma=(CheckBox) findViewById(R.id.ckb_suma);
        resta=(CheckBox) findViewById(R.id.ckb_resta);
        mult=(CheckBox) findViewById(R.id.ckb_mult);
        divi=(CheckBox) findViewById(R.id.ckb_divi);
        btn_productos =findViewById(R.id.btn_productos);
        //
        resultado=(TextView)findViewById(R.id.tv_resul_);
        //
        calcular=(Button) findViewById(R.id.btn_calcular_);
        //
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ss_num1= num1.getText().toString();
                ss_num2= num2.getText().toString();

                d_num1= Double.parseDouble(ss_num1);
                d_num2= Double.parseDouble(ss_num2);
                if(ss_num1.isEmpty()){
                    //Toast.makeText(this, "Ingrese número 1 o numero 2", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Checkboxes_operaciones.this, "Ingresar ambos mumeros", Toast.LENGTH_SHORT).show();

                }else{
                    metodo();
                }
                
            }
        });

        btn_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Checkboxes_operaciones.this,productos.class);
                startActivity(intent);
            }
        });
    }
    public  void metodo(){

            if(suma.isChecked()){
                resul=d_num1+d_num2;
                ss_resultado= ss_resultado+"La Suma es:"+resul+"\n";
            }if(resta.isChecked()){
                resul=d_num1-d_num2;
                ss_resultado= ss_resultado+"La Resta:"+resul+"\n";

            }if(mult.isChecked()){
                resul=d_num1*d_num2;
                ss_resultado= ss_resultado+"La Multiplicacion es:"+resul+"\n";

            }if(divi.isChecked()){
                resul=d_num1/d_num2;
                ss_resultado= ss_resultado+"La Divicion es:"+resul+"\n";

            }
            resultado.setText(ss_resultado);
    }
}