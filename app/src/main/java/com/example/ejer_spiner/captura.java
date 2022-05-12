package com.example.ejer_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class captura extends AppCompatActivity {
    private TextView cap;
    private Button btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);
        cap=(TextView) findViewById(R.id.tv_captura);
        btn_regresar=(Button) findViewById(R.id.btn_regresar);
        cap.setText("Dato: "+getIntent().getStringExtra("dato"));

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar(view);
            }
        });


    }
    public void regresar(View view){
        Intent regreso = new Intent(this,MainActivity.class);
        startActivity(regreso);
    }

}
