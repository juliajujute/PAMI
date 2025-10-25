package android.julia.modularloginjulia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_entrar, btn_criar;
    EditText edt_nome, edt_email, edt_senha;
    CheckBox credencial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponent();
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setNome(edt_nome.getText().toString());
                usuario.setEmail(edt_email.getText().toString());
                usuario.setSenha(edt_senha.getText().toString());

                Toast.makeText(MainActivity.this, "Dados: " +usuario.getNome() + "-" + usuario.getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initComponent() {
        edt_nome= findViewById(R.id.edt_nome);
        edt_email= findViewById(R.id.edt_email);
        edt_senha= findViewById(R.id.edt_senha);
        btn_entrar=findViewById(R.id.btn_entrar);
        btn_criar=findViewById(R.id.btn_criar);
    }
}