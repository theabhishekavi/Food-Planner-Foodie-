package com.example.food_plannerfoodie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CardView cardView_bfp = view.findViewById(R.id.cardview_bfp);
        CardView cardView_bmi = view.findViewById(R.id.cardview_bmi);
        CardView cardView_bmr = view.findViewById(R.id.cardview_bmr);
        CardView cardView_wym = view.findViewById(R.id.cardview_whats_your_motive);
        CardView cardView_dfi = view.findViewById(R.id.cardview_daily_food_intake);

        cardView_bfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new BFPFragment()).addToBackStack(null).commit();
            }
        });
        cardView_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new BMIFragment()).addToBackStack(null).commit();
            }
        });
        cardView_bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new BMRFragment()).addToBackStack(null).commit();
            }
        });
        cardView_wym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new WhatsYourMotiveFragment()).addToBackStack(null).commit();
            }
        });
        cardView_dfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,
                        new DailyFoodIntakeFragment()).addToBackStack(null).commit();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
