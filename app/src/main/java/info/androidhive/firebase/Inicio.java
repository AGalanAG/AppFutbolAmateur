package info.androidhive.firebase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Inicio extends Fragment {

    private DatabaseReference dbPrediccion;
    private ValueEventListener eventListener;
    private ImageView Echivas,ERival;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);



        final TextView  golChivas = (TextView)v.findViewById(R.id.txtgchivas);
        final TextView golRival = (TextView)v.findViewById(R.id.txtgrival);
        final TextView nrival = (TextView)v.findViewById(R.id.txtNRIVAL);
        final TextView resena = (TextView)v.findViewById(R.id.txtRESENA);
        Echivas = (ImageView)v.findViewById(R.id.EChivas);
        ERival = (ImageView)v.findViewById(R.id.ERival);


        String ImChivas = "https://firebasestorage.googleapis.com/v0/b/pciwap-aa143.appspot.com/o/Equipo%2Fchivas.png?alt=media&token=397f4cfe-a7b0-4715-9f16-e141dfa3de50";
         String ImRival ="https://firebasestorage.googleapis.com/v0/b/pciwap-aa143.appspot.com/o/EquiposRivales%2FpumasIzcalli.png?alt=media&token=8a8be146-a0dc-4eed-b70c-1f35eb519f51";

        Glide.with(Inicio.this)
                .load(ImChivas)
                .into(Echivas);
        dbPrediccion = FirebaseDatabase.getInstance().getReference().child("Inicio");
        Glide.with(Inicio.this)
                .load(ImRival)
                .into(ERival);
        dbPrediccion = FirebaseDatabase.getInstance().getReference().child("Inicio");


        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                golChivas.setText(dataSnapshot.child("GChivas").getValue().toString());
                golRival.setText(dataSnapshot.child("GRival").getValue().toString());
                nrival.setText(dataSnapshot.child("NRival").getValue().toString());
                resena.setText(dataSnapshot.child("Resena").getValue().toString());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        dbPrediccion.addValueEventListener(eventListener);


        return (v);
    }
}
