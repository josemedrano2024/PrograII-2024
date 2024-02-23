package com.example.parcial1progra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    TextView tempVal;
    Spinner spn;
    Button btn;
    Conversores objArea = new Conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhArea);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("ARE").setIndicator("AREA", null).setContent(R.id.Area));
        tbh.addTab(tbh.newTabSpec("AGU").setIndicator("AGUA", null).setContent(R.id.Agua));


        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeArea);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAarea);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objArea.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnObtener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Numero1 = Double.parseDouble(tempVal.getText().toString());
                double respuesta = 0;

                if (Numero1 <= 18) {
                    respuesta = 6.0;
                } else if (Numero1 <= 28) {
                    respuesta = 6.0 + 0.45 * (Numero1 - 18);
                } else {
                    respuesta = 6.0 + 0.45 * (28 - 18) + 0.65 * (Numero1 - 28);
                }

                tempVal = findViewById(R.id.Respuesta);
                tempVal.setText("Respuesta: " + respuesta);

            }
        });
    }
    private void mostrarResultado(double resultado) {
        String mensaje = String.format("Respuesta: %.1f", resultado);
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }

    private void mostrarError(String mensaje) {
        Toast.makeText(getApplicationContext(), "Error: " + mensaje, Toast.LENGTH_LONG).show();
    }

    class Conversores {
        double[][] valores =  {
                {1,0.6988,7.52,0.001,0.0001726,0.0000698}
        };
        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }
    }

}