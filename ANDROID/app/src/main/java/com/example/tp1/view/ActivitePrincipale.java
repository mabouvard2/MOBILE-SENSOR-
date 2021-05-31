package com.example.tp1.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tp1.R;
import com.google.android.material.navigation.NavigationView;

/**
 * Il s'agit de la classe gérant l'activité principale de notre application: le menu
 */
public class ActivitePrincipale extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button button;
    EditText editText;


    /**
     * Methode lors de la création de l'activité
     * @param saveInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activite_principale);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        button=findViewById(R.id.bouton);
        editText= (EditText) findViewById(R.id.editText);

        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button button = findViewById(R.id.bouton);


        button.setOnClickListener(new View.OnClickListener() {
            /**
             * réagit au click du bouton jeu
             * @param v vue nécessaire
             */
            @Override
            public void onClick(View v) {
                openJeu();
            }
        });



        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }

    /**
     * permet d'obtenir la valeur de la vitesse de l'utilisateur
     * @return la vitesse
     */
    public Integer getValeurVitesse()
    {
        int vitesse = 20;
        String str = editText.getText().toString();
        boolean isNumeric = str.matches("[+-]?\\d*(\\.\\d+)?");
        if(isNumeric && str != null && str!="Choisissez votre vitesse")
        {
            try {
                vitesse = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
        return vitesse;
    }

    /**
     * méthode lanceant le jeu
     */
    public void openJeu(){
        Intent intent = new Intent(ActivitePrincipale.this,JeuMain.class);
        intent.putExtra("vitesse",getValeurVitesse());
        startActivity(intent);
    }

    /**
     * méthode réagissant lorsque le bouton de retour est appuyé
     */
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
        }

    /**
     * Réagit dès qu'un item du menu est sélectionné
     * @param menuItem il s'agit du menu
     * @return true
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_profile:
                Intent intent = new Intent(ActivitePrincipale.this,Participant.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Toast.makeText(this,"ballgame@gmail.com",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
