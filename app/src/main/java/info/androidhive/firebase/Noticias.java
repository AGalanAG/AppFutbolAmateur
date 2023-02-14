package info.androidhive.firebase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Noticias extends Fragment {

    private DatabaseReference dbPrediccion,dbPrediccion1,dbPrediccion2;
    private ValueEventListener eventListener;
    private ImageView ImN1M,ImN2M,ImN3M;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_noticias, container, false);

        final TextView Titulo1 = (TextView)v.findViewById(R.id.N1Titulo1);
        final TextView Texto1 = (TextView)v.findViewById(R.id.N1Texto1);
        final TextView Titulo2 = (TextView)v.findViewById(R.id.N2Titulo2);
        final TextView Texto2 = (TextView)v.findViewById(R.id.N2Texto2);
        final TextView Titulo3 = (TextView)v.findViewById(R.id.N3Titulo3);
        final TextView Texto3 = (TextView)v.findViewById(R.id.N3Texto3);
        ImN1M = (ImageView)v.findViewById(R.id.ImN1);
        ImN2M = (ImageView)v.findViewById(R.id.ImN2);
        ImN3M = (ImageView)v.findViewById(R.id.ImN3);
        String ImN1D="https://firebasestorage.googleapis.com/v0/b/pciwap-aa143.appspot.com/o/Noticias%2Fdueno.jpg?alt=media&token=2b552749-0240-4638-abf2-e37d336b6373";
        String ImN2D="https://firebasestorage.googleapis.com/v0/b/pciwap-aa143.appspot.com/o/Noticias%2Fbarca.jpg?alt=media&token=a2db4b12-5eac-498a-a2df-0da0599f23ef";
        String ImN3D="https://firebasestorage.googleapis.com/v0/b/pciwap-aa143.appspot.com/o/Noticias%2Fim_equipo.jpg?alt=media&token=edf5f22e-36b1-4479-b9e1-aa7a266b108d";

        Glide.with(Noticias.this)
                .load(ImN1D)
                .into(ImN1M);
        Glide.with(Noticias.this)
                .load(ImN2D)
                .into(ImN2M);
        Glide.with(Noticias.this)
                .load(ImN3D)
                .into(ImN3M);

        dbPrediccion = FirebaseDatabase.getInstance().getReference().child("Noticias").child("Articulo1");
        dbPrediccion1 = FirebaseDatabase.getInstance().getReference().child("Noticias").child("Articulo2");
        dbPrediccion2 = FirebaseDatabase.getInstance().getReference().child("Noticias").child("Articulo3");


        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Titulo1.setText(dataSnapshot.child("Titulo").getValue().toString());
                Texto1.setText(dataSnapshot.child("Texto").getValue().toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        dbPrediccion.addValueEventListener(eventListener);

        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Titulo2.setText(dataSnapshot.child("Titulo").getValue().toString());
                Texto2.setText(dataSnapshot.child("Texto").getValue().toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        dbPrediccion1.addValueEventListener(eventListener);

        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Titulo3.setText(dataSnapshot.child("Titulo").getValue().toString());
                Texto3.setText(dataSnapshot.child("Texto").getValue().toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        dbPrediccion2.addValueEventListener(eventListener);




        return (v);
    }

}
