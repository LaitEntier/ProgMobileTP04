package com.example.tp04.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//import com.example.tp04.NatureFragment;
import com.example.tp04.AutumnFragment;
import com.example.tp04.NatureFragment;
import com.example.tp04.R;
import com.example.tp04.SpringFragment;
import com.example.tp04.SummerFragment;
import com.example.tp04.WinterFragment;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    public int getCount() {
        // Nombre de pages à considérer.
        return 4;
    }

    public Fragment getItem(int position) {
        switch (position) {/*
            case 0:
                return NatureFragment.newInstance(0, mContext.getString(R.string.titre_section0));
            case 1:
                return NatureFragment.newInstance(1, mContext.getString(R.string.titre_section1));
            case 2:
                return NatureFragment.newInstance(2, mContext.getString(R.string.titre_section2));
                */
            case 0:
                return SpringFragment.newInstance(0,"Printemps");
            case 1:
                return SummerFragment.newInstance(1,"Eté");
            case 2:
                return AutumnFragment.newInstance(2,"Automne");
            case 3:
                return WinterFragment.newInstance(3,"Hiver");

        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        Drawable icon=null;
        switch (position) {
            /*
            case 0:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_mineral);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_vegetal);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_animal);
                break;
             */
            case 0:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_mineral);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_vegetal);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_animal);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icon = mContext.getResources().getDrawable(R.drawable.ic_vegetal);
                break;
        }
        SpannableString sb = new SpannableString(" " + titre);
        // un espace est ajouté pour séparer le texte de l'image

        icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icon, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }
}