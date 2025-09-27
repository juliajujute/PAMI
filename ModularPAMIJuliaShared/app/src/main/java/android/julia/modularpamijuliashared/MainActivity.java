package android.julia.modularpamijuliashared;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //PRIMEIRO PASSO
    //preferences variavel intanciada
    SharedPreferences preferences;
    //constante = prefsname
    //final significa que o nome do arquivo mesmo que com mudanças sera shared
    public static final String PREFS_NAME = "shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //SEGUNDO PASSO
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor meusdados = preferences.edit();


        //nome da
        meusdados.putString("Nome", "Julia");
        meusdados.putString("email", "juliatenorio@com");
        meusdados.putString("Senha", "1234");

        meusdados.apply();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}