package com.rujirakongsomran.livedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rujirakongsomran.livedata.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    MainViewModel mainViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInstances();
        return view;
    }

    private void initInstances() {
        if (getActivity() != null) {
            // When activity is not null
            // Initialize view model
            mainViewModel = ViewModelProviders.of(getActivity())
                    .get(MainViewModel.class);

            // Set observer on get text method
            mainViewModel.getText().observe(getActivity(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    // When text change
                    binding.tvResult.setText(s);
                }
            });

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}