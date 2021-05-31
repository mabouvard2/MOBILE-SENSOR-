package com.example.tp1.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.R;
import com.example.tp1.model.Avis;

import java.util.List;

public class MonAdaptateur extends RecyclerView.Adapter<MonViewHolder> {
//liste d'avis
    private final List<Avis> lesAvis;

    /**
     *  Constructeur de MonAdaptateur
     * @param lesAvis la liste d'avis que dont on veut s'occuper
     */
    public MonAdaptateur(List<Avis> lesAvis) { this.lesAvis = lesAvis; }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_avis,parent,false);
        return new MonViewHolder(layout);
    }

    /**
     *  bind de la vue
     * @param holder le view holder dans lequel on effectue les actions
     * @param position la position de l'avis dans la liste
     */
    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        Avis avisCourrant = lesAvis.get(position);
        ((MonViewHolder)holder).getLeCheckBox().setText(lesAvis.get(position).getNom());
        ((MonViewHolder)holder).setAvisCourant(avisCourrant);
        ((MonViewHolder)holder).getLeCheckBox().setChecked(avisCourrant.isCoche());
    }
    /**
     *  getter du nombre dans la list
     * @return int longueur de la list
     */
    @Override
    public int getItemCount() {
        return lesAvis.size();
    }
}
