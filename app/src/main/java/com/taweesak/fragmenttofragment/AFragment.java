package com.taweesak.fragmenttofragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    TextView textViewA;
    EditText editTextA;
    Button buttonA;
    FragmentManager fragmentManager;
    BFragment bFragment;
    AFragment aFragment;
    PageViewModel pageViewModel;

    public AFragment() {
        // Required empty public constructor
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init ViewModel
        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewA = view.findViewById(R.id.textView_fmA);
        editTextA = view.findViewById(R.id.edit_text_fmA);
        buttonA = view.findViewById(R.id.button_fmA);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pageViewModel.setName(editTextA.getText().toString());
            }
        });

        pageViewModel.getName().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //txtName.setText(s);
                Toast.makeText(getActivity(),"Str = "+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
