package com.example.tp04;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class SeasonsFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static SeasonsFragment newInstance(int position, String title) {
        SeasonsFragment fragment = new SeasonsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seasons, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page+1 + " - " + title);

        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gridLayout);

        LinearLayout linearLayout = (LinearLayout) gridLayout.findViewById(R.id.linearLayout00);
        ImageView image00 = (ImageView) linearLayout.findViewById(R.id.imageView00);
        image00.setImageResource(R.drawable.img_spring);
        TextView tv00 = (TextView) linearLayout.findViewById(R.id.textView00);
        tv00.setText(R.string.spring);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                SpringFragment sf = new SpringFragment();
                sf.setArguments(args);
                fr.replace(R.id.seasonsFragment, sf);
                fr.commit();

                /*https://stackoverflow.com/questions/16761812/change-viewpager-fragment-by-a-buttonclick
                ViewPager viewPager = null;
                viewPager.setCurrentItem(1);
                */


            }
        });

        ImageView image01 = (ImageView) gridLayout.findViewById(R.id.imageView01);
        image01.setImageResource(R.drawable.img_summer);
        TextView tv01 = (TextView) view.findViewById(R.id.textView01);
        tv01.setText(R.string.summer);

        ImageView image10 = (ImageView) gridLayout.findViewById(R.id.imageView10);
        image10.setImageResource(R.drawable.img_autumn);
        TextView tv10 = (TextView) view.findViewById(R.id.textView10);
        tv10.setText(R.string.autumn);

        ImageView image11 = (ImageView) gridLayout.findViewById(R.id.imageView11);
        image11.setImageResource(R.drawable.img_winter);
        TextView tv11 = (TextView) view.findViewById(R.id.textView11);
        tv11.setText(R.string.winter);

        return view;
    }

}
