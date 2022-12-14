package com.example.ejercicios2doparcial.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ejercicios2doparcial.R;

public class HomeHeaderFragment extends Fragment {
    ImageView ivHeader;

    public HomeHeaderFragment(){
        super(R.layout.fragment_home_header);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivHeader = view.findViewById(R.id.iv_header);
        ivHeader.setImageResource(getArguments().getInt("drawable"));
    }
}