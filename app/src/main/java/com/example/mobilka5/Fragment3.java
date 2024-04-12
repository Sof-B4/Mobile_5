package com.example.mobilka5;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

public class Fragment3 extends Fragment {
    private static final String TAG = "MyApp";
    private int defaultValue = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.activity_main, container, false);

        View view = inflater.inflate(R.layout.fragment3, container, false);

        TextView textViewSection = view.findViewById(R.id.textGet);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String section = bundle.getString("bundleKey");
            if (section != null) {
                textViewSection.setText(section);
            }
        }


        return view;

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView = view.findViewById(R.id.textViewTitle);
        //EditText editText = view.findViewById(R.id.editTextTraining);

        Button button = view.findViewById(R.id.buttonSubmit);
        Button button2 = view.findViewById(R.id.button_end);

        EditText editText_name = view.findViewById(R.id.editTextFirstName);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                String sectionToPass = editText_name.getText().toString();
                result.putString("bundleKey2", sectionToPass);

                Navigation.findNavController(view).navigate(R.id.action_fragment3_to_fragment22, result);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_global_mainFragment);
            }
        });



    }
}