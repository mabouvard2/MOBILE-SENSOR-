package com.example.tp1.view.adapter;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.R;
import com.example.tp1.model.Avis;

public class MonViewHolder extends RecyclerView.ViewHolder {
//checkbox que l'on veut prendre
    private final CheckBox leCheckBox;

    /**
     *  findId de la checkbox
     * @param itemView on recupere l'item de la view (qui sera forcement non null)
     */
    public MonViewHolder(@NonNull View itemView) {
        super(itemView);
        leCheckBox = itemView.findViewById(R.id.textViewJoueur);

    }

    /**
     *  getter du checkbox
     * @return CheckBox retourne la checkbox
     */
    public CheckBox getLeCheckBox() {
        return leCheckBox;
    }

    /**
     *  setter de la checkbox
     * @param avisCourant permet de definir l'avis courant
     */
    public void setAvisCourant(Avis avisCourant) {
        leCheckBox.setOnClickListener(v -> avisCourant.setCoche(leCheckBox.isChecked()));
    }
}
