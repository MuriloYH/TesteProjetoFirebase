package br.hgtechnologies.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView chamadosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List<String> chamados = buscaChamados(nomeFila);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,chamados);
        chamadosListView.setAdapter(adapter);
        chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                Intent intent =
                        new Intent (ListaChamadosActivity.this,
                                DetalhesChamadoActivity.class );
                intent.putExtra("chamado_escolhido",
                        chamados.get(position));
                startActivity(intent);
            }
        });
    }

    public List<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("SeguranÃ§a e Auditoria: Camila Gomes dos Reis                         RA 81727341.");
        lista.add("SeguranÃ§a e Auditoria: Cleomacio Silva de Oliveira                   RA 817122831.");
        lista.add("SeguranÃ§a e Auditoria: Fernanda Soares dos Reis                      RA 81721367.");
        lista.add("SeguranÃ§a e Auditoria: Gustavo Almeida                               RA 81722993.");
        lista.add("SeguranÃ§a e Auditoria: Leonardo Martinez Avibar                      RA 81721366.");
        lista.add("SeguranÃ§a e Auditoria: Lucas de Freitas Pinheiro                     RA 81727525.");
        lista.add("SeguranÃ§a e Auditoria: Murilo Yudji Hara                             RA 81726559.");
        lista.add("SeguranÃ§a e Auditoria: NatÃ¡lia Sanchez                               RA 81725719.");
        lista.add("SeguranÃ§a e Auditoria: Victor Gabriel Nunes                          RA 81722175.");
        lista.add("SeguranÃ§a e Auditoria: VinÃ­cius Oliveira GonÃ§alves                   RA 81723868.");
        lista.add("Projeto Interdisciplinar: Grupo 2 - Camila Gomes                       RA 81727341.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - Cleomacio Silva                    RA 817122831.");
        lista.add("Projeto Interdisciplinar: Grupo 2 - Fernanda Soares                    RA 81721367.");
        lista.add("Projeto Interdisciplinar: Grupo 2 - Gustavo Almeida                    RA 81722993.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - Leonardo Martin                    RA 81721366.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - Lucas de Freitas                   RA 81727525.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - Murilo Yudji Hara                  RA 81726559.");
        lista.add("Projeto Interdisciplinar: Grupo 2 - NatÃ¡lia Sanchez                    RA 81725719.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - Victor Gabriel                     RA 81722175.");
        lista.add("Projeto Interdisciplinar: Grupo 1 - VinÃ­cius Oliveira                  RA 81723868.");
        return lista;
    }

    public List<String> buscaChamados(String chave){
        List<String> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        }
        else {
            List<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

}
