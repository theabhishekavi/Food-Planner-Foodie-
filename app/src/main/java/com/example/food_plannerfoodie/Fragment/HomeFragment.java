package com.example.food_plannerfoodie.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food_plannerfoodie.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
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

        cardView_bfp.setOnClickListener(this);
        cardView_bmi.setOnClickListener(this);
        cardView_bmr.setOnClickListener(this);
        cardView_wym.setOnClickListener(this);
        cardView_dfi.setOnClickListener(this);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new HomeFragment();
        switch (v.getId()){

            case R.id.cardview_bmi:
                fragment = new BMIFragment();
                break;
            case R.id.cardview_bmr:
                fragment = new BMRFragment();
                break;
            case R.id.cardview_bfp:
                fragment = new BFPFragment();
                break;
            case R.id.cardview_daily_food_intake:
                fragment = new DailyFoodIntakeFragment();
                break;
            case R.id.cardview_whats_your_motive:
                fragment = new WhatsYourMotiveFragment();
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.content_frame,
                fragment).addToBackStack(null).commit();
    }
}
