package com.example.mylistapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private String[] ALPHONSE = new String[]{};

    private ListView listNames = null;
    private Button btnFirst = null;

    private Bundle nextPage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ALPHONSE = getResources().getStringArray(R.array.Sport);
        listNames = view.findViewById(R.id.listAlphonse);
        btnFirst = view.findViewById(R.id.button_first);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getContext(), android.R.layout.simple_list_item_1, ALPHONSE);
        listNames.setAdapter(adapter);

        listNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();

                nextPage = new Bundle();
                nextPage.putInt("Position", position);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, nextPage);
            }
        });

        /*btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, nextPage);
            }
        });*/
    }
}