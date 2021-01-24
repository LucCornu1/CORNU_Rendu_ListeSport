package com.example.mylistapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.Objects;

public class SecondFragment extends Fragment {

    private TextView txt_Title = null;
    private TextView txt_Desc = null;
    private ImageView img_Mage = null;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_Title = view.findViewById(R.id.textview_title);
        txt_Desc = view.findViewById(R.id.textview_description);
        img_Mage = view.findViewById(R.id.img_Mage);

        /*assert getArguments() != null;
        Toast.makeText(getContext(), ""+getArguments().getInt("Position"), Toast.LENGTH_SHORT).show();*/
        adaptContent(view, getArguments().getInt("Position"));

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    protected void adaptContent(View view, int i) {
        switch (i) {
            case 0:
                txt_Title.setText("Foot");
                txt_Desc.setText("Le foot est un sport d'équipe");
                img_Mage.setImageResource(R.drawable.foot);
                break;

            case 1:
                txt_Title.setText("Ski");
                txt_Desc.setText("Le ski est un sport solo");
                img_Mage.setImageResource(R.drawable.ski);
                break;

            case 2:
                txt_Title.setText("Deltaplane");
                txt_Desc.setText("Le deltaplane est un sport dangereux");
                img_Mage.setImageResource(R.drawable.deltaplane);
                break;

            case 3:
                txt_Title.setText("Cheval");
                txt_Desc.setText("Le deltaplane est un sport avec un animal");
                img_Mage.setImageResource(R.drawable.cheval);
                break;

            case 4:
                txt_Title.setText("Course à pied");
                txt_Desc.setText("La course à pied est un sport simple");
                img_Mage.setImageResource(R.drawable.course);
                break;

            case 5:
                txt_Title.setText("Saut en longueur");
                txt_Desc.setText("Le saut en longueur est un sport compétitif");
                img_Mage.setImageResource(R.drawable.saut);
                break;

            case 6:
                txt_Title.setText("Faire les exercices à la derniere minute");
                txt_Desc.setText("Faire les exercices à la derniere minute est sport maîtrise par la classe de Bachelor");
                img_Mage.setImageResource(R.drawable.last);
                break;

            case 7:
                txt_Title.setText("Marathon");
                txt_Desc.setText("Le marathon est un sport long");
                img_Mage.setImageResource(R.drawable.marathon);
                break;
        }
    }
}