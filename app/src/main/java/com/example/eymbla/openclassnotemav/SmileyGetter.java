package com.example.eymbla.openclassnotemav;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

/**
 * Récupère une image depuis les ressources
 * pour les ajouter dans l'interpréteur HTML
 */
public class SmileyGetter implements ImageGetter {
    /* Context de notre activité */
    protected Context context = null;

    public SmileyGetter(Context c) {
        context = c;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    /**
     * Donne un smiley en fonction du paramètre d'entrée
     * @param smiley Le nom du smiley à afficher
     */
    public Drawable getDrawable(String smiley) {
        Drawable retour;

        //On récupère le gestionnaire de ressources
        Resources resources = context.getResources();

        //Si on désire le clin d'oeil..
        if(smiley.compareTo("clin") == 0)
            //... alors on récupère le Drawable correspondant
            retour = resources.getDrawable(R.drawable.clin);
        else if(smiley.compareTo("smile") == 0)
            retour = resources.getDrawable(R.drawable.smile);
        else
            retour = resources.getDrawable(R.drawable.heureux);
        //On délimite l'image (elle va de son coin en haut à gauche à son coin en bas à droite)
        retour.setBounds(0, 0, retour.getIntrinsicWidth(), retour.getIntrinsicHeight());
        return retour;
    }
}
