package br.hgtechnologies.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText senhaEditText;
    private FirebaseAuth mAuth;

    FirebaseFirestore firestoreInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText = findViewById(R.id.loginEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        mAuth = FirebaseAuth.getInstance();
        firestoreInstance = FirebaseFirestore.getInstance();


        String email = "admin@email.com";
        String senha = "123456";

        firestoreInstance.collection("usuarios").document(email).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.get("tipo").equals("admin")){
                    String login = loginEditText.getEditableText().toString();
                    String senha = senhaEditText.getEditableText().toString();
                    mAuth.signInWithEmailAndPassword(login,
                            senha).addOnSuccessListener((result) -> {
                        startActivity (new Intent (MainActivity.this, BuscaDeListaActivity.class));
                    }).addOnFailureListener((exception) -> {
                        exception.printStackTrace();
                        Toast.makeText(MainActivity.this, exception.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    });
                }
                else{

                }
            }
        });
    }

    public void irParaCadastro (View view){
        startActivity (new Intent(this, NovoUsuarioActivity.class));
    }

}
