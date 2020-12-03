package com.example.danielfigueroa_parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private TextView preguntaCelular;
    private EditText puntajeCelular;
    private Button okBoton;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preguntaCelular=findViewById(R.id.preguntaCelular);
        puntajeCelular=findViewById(R.id.puntajeCelular);
        okBoton=findViewById(R.id.okBoton);

        db = FirebaseDatabase.getInstance();
        db.getReference().child("preguntas").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot child: snapshot.getChildren()){ //por cada elemento mida los valores
                            Pregunta pregunta = child.getValue(Pregunta.class);
                            if(pregunta.getNivel() == 1){
                                preguntaCelular.setText(pregunta.getPregunta());
                                id = pregunta.getId();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );

        okBoton.setOnClickListener(
                (v)->{
                int cantidadVotacion = Integer.parseInt(puntajeCelular.getText().toString());//variable que agarra lo escrito en el input y lo convierte en un entero.
                if (cantidadVotacion >= 0 && cantidadVotacion <= 10){
                    Votacion votacion = new Votacion(id, cantidadVotacion);
                    db.getReference().child("votos/"+id).setValue(votacion);
                    }
                }
        );
    }
}