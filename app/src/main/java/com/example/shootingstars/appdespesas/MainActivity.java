package com.example.shootingstars.appdespesas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText transporte, alimentacao, vestuario, salario;
    private TextView transporte2, alimentacao2, vestuario2, total, total_porcento, saldo_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transporte = findViewById(R.id.editTransporte);
        alimentacao = findViewById(R.id.editAlimentacao);
        vestuario = findViewById(R.id.editVestuario);
        salario = findViewById(R.id.editSalario);
        transporte2 = findViewById(R.id.textViewTransporte);
        alimentacao2 = findViewById(R.id.textViewAlimentacao);
        vestuario2 = findViewById(R.id.textViewVestuario);
        total = findViewById(R.id.textViewTotal2);
        total_porcento = findViewById(R.id.textViewTotal1);
        saldo_total = findViewById(R.id.textViewSaldo);
    }

    public void calcularDespesas(View view) {
        String pega_transporte = transporte.getText().toString();
        String pega_alimentacao = alimentacao.getText().toString();
        String pega_vestuario = vestuario.getText().toString();
        String pega_salario = salario.getText().toString();
        if (view.getId() == R.id.buttonCalcular) {

            float number_transporte = Float.parseFloat(pega_transporte);
            float number_alimentacao = Float.parseFloat(pega_alimentacao);
            float number_vestuario = Float.parseFloat(pega_vestuario);
            float number_salario = Float.parseFloat(pega_salario);

            float transporte_porcentagem = ((number_transporte / number_salario) * 100);
            float alimentacao_porcentagem = ((number_alimentacao / number_salario) * 100);
            float vestuario_porcentagem = ((number_vestuario / number_salario) * 100);
            float valor_total = number_transporte + number_alimentacao + number_vestuario;
            float valor_porcentagem = ((valor_total / number_salario) * 100);

            if (number_salario >= valor_total) {

                transporte2.setText("Transporte: " + String.valueOf(transporte_porcentagem) + "%");

                alimentacao2.setText("Alimentação: " + String.valueOf(alimentacao_porcentagem) + "%");

                vestuario2.setText("Vestuario: " + String.valueOf(vestuario_porcentagem) + "%");

                total.setText("Total: R$" + String.valueOf(valor_total));

                total_porcento.setText("Total Em %: " + String.valueOf(valor_porcentagem) + "%");

                saldo_total.setText("Saldo: Positivo");
            }

            else {

                transporte2.setText(String.valueOf(number_transporte));

                alimentacao2.setText(String.valueOf(number_alimentacao));

                vestuario2.setText(String.valueOf(number_vestuario));

                total.setText(String.valueOf(valor_total));

                total_porcento.setText("Total Em%: Porcentagem Acima do limite");

                saldo_total.setText("Saldo: Negativo");

            }

        }
    }
}
