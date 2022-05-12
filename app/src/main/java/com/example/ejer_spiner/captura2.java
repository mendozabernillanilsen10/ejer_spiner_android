package com.example.ejer_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class captura2 extends AppCompatActivity {
    private TextView categoria,familia,producto,presentacion,estado;
    private Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura2);

        categoria=(TextView)findViewById(R.id.tv_categoria);
        familia=(TextView)findViewById(R.id.tv_familia);
        producto=(TextView)findViewById(R.id.tv_producto);
        presentacion=(TextView)findViewById(R.id.tv_presentacion);
        estado=(TextView)findViewById(R.id.tv_estado);
        regresar=(Button)findViewById(R.id.btn_regresar) ;

        categoria.setText("Categoria: "+getIntent().getStringExtra("categoria"));
        familia.setText("Familia: "+getIntent().getStringExtra("familia"));
        producto.setText("Producto: "+getIntent().getStringExtra("producto"));
        presentacion.setText(getIntent().getStringExtra("presentacion"));
        estado.setText(getIntent().getStringExtra("Estado"));
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar= new Intent(captura2.this,productos.class);
                startActivity(regresar);

            }
        });



    }
}