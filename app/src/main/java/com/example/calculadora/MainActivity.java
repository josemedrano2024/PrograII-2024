package com.example.calculadora;

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
    Conversores objConversor = new Conversores();
    CalcularMoneda objMoneda = new CalcularMoneda();
    CalcularAlmacenamiento objAlmacenamiento = new CalcularAlmacenamiento();
    CalcularTiempo objTiempo = new CalcularTiempo();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("LON").setIndicator("LONGITUD", null).setContent(R.id.Longitud));
        tbh.addTab(tbh.newTabSpec("MON").setIndicator("MONEDAS", null).setContent(R.id.Monedas));
        tbh.addTab(tbh.newTabSpec("ALM").setIndicator("ALMACENAMIENTO", null).setContent(R.id.Almacenamiento));

        btn = findViewById(R.id.btnConvertirLongitud);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeLongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnALongitud);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidadLongitud);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objConversor.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeMoneda);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMoneda);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad1);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objMoneda.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeAlmacenamiento);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAalmacenamiento);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objAlmacenamiento.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
            }
        });

        btn = findViewById(R.id.btnConvertir2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDeTiempo);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnATiempo);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad2);
                try {
                    double cantidad = Double.parseDouble(tempVal.getText().toString());
                    double resp = objTiempo.convertir(0, de, a, cantidad);
                    mostrarResultado(resp);
                } catch (NumberFormatException e) {
                    mostrarError("Ingresa una cantidad válida.");
                }
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
}

class CalcularMoneda {
    double[][] valores =  {
            {1.0, 0.93, 17.19, 0.79, 0.91}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class Conversores {
    double[][] valores = {
            {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularAlmacenamiento {
    double[][] valores =  {
            {}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}

class CalcularTiempo {
    double[][] valores =  {
            {}
    };

    public double convertir(int opcion, int de, int a, double cantidad) {
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}