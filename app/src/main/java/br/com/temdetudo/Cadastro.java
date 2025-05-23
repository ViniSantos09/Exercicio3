package br.com.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity {

    private Button btnConfirmarCadastro;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        btnConfirmarCadastro = findViewById(R.id.btnConfirmarCadastro);
        editText = findViewById(R.id.editText);

        btnConfirmarCadastro.setOnClickListener(view -> {
            String nome = editText.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("nome", nome);

            Intent intent = new Intent(this, ConfirmCadastro.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}