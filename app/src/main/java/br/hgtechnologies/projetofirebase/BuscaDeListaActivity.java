package br.hgtechnologies.projetofirebase;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class BuscaDeListaActivity extends AppCompatActivity {

    private EditText nomeFilaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_de_lista);
        nomeFilaEditText = findViewById(R.id.nomeFilaEditText);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeFila =
                        nomeFilaEditText.getEditableText().toString();
                Intent intent =
                        new Intent (BuscaDeListaActivity.this,
                                ListaChamadosActivity.class);
                intent.putExtra("nome_fila", nomeFila);
                startActivity(intent);
            }
        });
    }
    

}
