package com.example.udemyslider;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

public class imagefragments extends Fragment {

    private ImageView image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragments_img , container , false);
        image = (ImageView) view.findViewById(R.id.cityImage);

        Bundle bundle = getArguments();
        if(null != bundle){
            String url = bundle.getString("imageUrl" , " 1");

            Glide.with(getActivity())
                    .asBitmap()
                    .load(url)
                    .into(image);
        }

        return view;
    }
}
