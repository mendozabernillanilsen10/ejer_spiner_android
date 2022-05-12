package com.example.ejer_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class productos extends AppCompatActivity {
    private Spinner sp_categoria, sp_familia, sp_producto;
    private RadioButton rb_caja, rb_bolsa, rb_botella;
    private RadioButton rb_malEstado, rb_vencido, rb_stock;
    private Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        sp_categoria = (Spinner) findViewById(R.id.sp_categoria);
        sp_familia = (Spinner) findViewById(R.id.sp_familia);
        sp_producto = (Spinner) findViewById(R.id.sp_producto);
        //
        rb_caja = (RadioButton) findViewById(R.id.rb_caja);
        rb_bolsa = (RadioButton) findViewById(R.id.rb_bolsa);
        rb_botella = (RadioButton) findViewById(R.id.rb_botella);
        //
        rb_malEstado = (RadioButton) findViewById(R.id.rb_malEstado);
        rb_vencido = (RadioButton) findViewById(R.id.rb_vencido);
        rb_stock = (RadioButton) findViewById(R.id.rb_stock);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        // vectores
        String categoria[] = {"Bebidas", "Alimentos", "Artefactos"};
        ArrayAdapter<String> categoria_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categoria);
        sp_categoria.setAdapter(categoria_adapter);
        //
        sp_categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categori = adapterView.getItemAtPosition(i).toString();
                getFamilia(categori);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_familia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String familia = adapterView.getItemAtPosition(i).toString();
                getProdcutos(familia);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rb_malEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_malEstado.isChecked()) {
                    rb_stock.setChecked(false);
                }
            }
        });
        rb_vencido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_vencido.isChecked()) {
                    rb_stock.setChecked(false);
                }
            }
        });
        rb_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_stock.isChecked()) {
                    rb_vencido.setChecked(false);
                    rb_malEstado.setChecked(false);
                }
            }
        });
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar_dato();
            }
        });
    }

    private void getFamilia(String cat) {
        String familia[] = new String[3];
        if (cat == "Bebidas") {
            familia[0] = "Cerveza";
            familia[1] = "Gaseosa";
            familia[2] = "Agua";

        } else if (cat == "Alimentos") {
            familia[0] = "Postes";
            familia[1] = "Galletas";
            familia[2] = "Panes";
        } else if (cat == "Artefactos") {
            familia[0] = "Telivisores";
            familia[1] = "Lavadoras";
            familia[2] = "Refigeradoras";

        }
        ArrayAdapter<String> familia_adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, familia);
        sp_familia.setAdapter(familia_adapter);

    }

    private void getProdcutos(String fami) {
        String productos[] = new String[3];
        if (fami == "Cerveza") {
            productos[0] = "Cerveza Pilsen";
            productos[1] = "Cerveza Cristal";
            productos[2] = "Cerveza Cuzqueña";

        } else if (fami == "Gaseosa") {
            productos[0] = "Coca Cola";
            productos[1] = "Inka Cola";
            productos[2] = "Pepsi";
        } else if (fami == "Agua") {
            productos[0] = "San Carlos";
            productos[1] = "San Mateo";
            productos[2] = "San Marcos";
        } else if (fami == "Postres") {
            productos[0] = "Arroz con leche";
            productos[1] = "Flan";
            productos[2] = "Torta helada";
        } else if (fami == "Galletas") {
            productos[0] = "Picaras";
            productos[1] = "Morocha";
            productos[2] = "Casino";
        } else if (fami == "Panes") {
            productos[0] = "Italiano";
            productos[1] = "Francés";
            productos[2] = "Chabate";
        } else if (fami == "Telivisores") {
            productos[0] = "TV. Sansung";
            productos[1] = "TV. LG";
            productos[2] = "TV. SONY";
        } else if (fami == "Lavadoras") {
            productos[0] = "Lav. Sansung";
            productos[1] = "Lav. LG";
            productos[2] = "Lav. SONY";
        } else if (fami == "Refrigeradoras") {
            productos[0] = "Ref. Sansung";
            productos[1] = "Ref. LG";
            productos[2] = "Ref. SONY";
        }
        ArrayAdapter<String> produc_adap = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, productos);
        sp_producto.setAdapter(produc_adap);
    }

    private String datos_presentacion() {
        String datosPres = " ";
        if (rb_bolsa.isChecked()) {
            datosPres = "Presentacion: Bolsa";
        } else if (rb_caja.isChecked()) {
            datosPres = "Presentacion: Caja";
        } else if (rb_botella.isChecked()) {
            datosPres = "Presentacion: Botella";

        }
        return datosPres;
    }

    private String datos_estado() {
        String datoEstado = "";
        if (rb_malEstado.isChecked()) {
            datoEstado = "producto en mal estado\n";
        } else if (rb_vencido.isChecked()) {
            datoEstado = "producto Vencido\n";
        } else if (rb_stock.isChecked()) {
            datoEstado = "producto sin Stock\n";
        }
        return datoEstado;
    }

    private void enviar_dato() {
        Intent enviar = new Intent(this, captura2.class);
        enviar.putExtra("categoria", sp_categoria.getSelectedItem().toString());
        enviar.putExtra("familia", sp_familia.getSelectedItem().toString());
        enviar.putExtra("producto", sp_producto.getSelectedItem().toString());
        enviar.putExtra("presentacion", datos_presentacion());
        enviar.putExtra("Estado", datos_estado());
        startActivity(enviar);

    }
}