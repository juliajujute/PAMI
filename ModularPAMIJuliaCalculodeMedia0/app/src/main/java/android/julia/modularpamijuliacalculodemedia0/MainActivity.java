package android.julia.modularpamijuliacalculodemedia0;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nota1, nota2, nota3, nota4, faltas;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();

        btnCalcular.setOnClickListener(view->{
            validaCampos();
            calcularMedia();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calcularMedia() {
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());
        double f = Double.parseDouble(faltas.getText().toString());

        double media = (n1 + n2 + n3 +n4)/4;

        if(media > 7){
            if (f < 20){
                txtResultado.setTextColor(Color.parseColor("#437845"));
                txtResultado.setText("Aluno aprovado com media " + media);
            }else{
                txtResultado.setTextColor(Color.parseColor("#f44336"));
                txtResultado.setText("Excesso de faltas " +f + " faltas");
            }
        }else{
            txtResultado.setTextColor(Color.parseColor("#f44336"));
            txtResultado.setText("Aluno reprovado com média " + media);
        }
    }

    private void validaCampos() {
        if (TextUtils.isEmpty(nota1.getText())) {
            nota1.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(nota2.getText())) {
            nota2.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(nota3.getText())) {
            nota3.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(nota4.getText())) {
            nota4.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(faltas.getText())) {
            faltas.setError("Esse campo não pode estar vazio");
        }
    }

    private void initComponents() {
        nota1 = findViewById(R.id.edt_nota1);
        nota2 = findViewById(R.id.edt_nota2);
        nota3 = findViewById(R.id.edt_nota3);
        nota4 = findViewById(R.id.edt_nota4);
        txtResultado = findViewById(R.id.txt_resultado);
        faltas = findViewById(R.id.edt_faltas);
        btnCalcular = findViewById(R.id.btn_calcular);


    }
}