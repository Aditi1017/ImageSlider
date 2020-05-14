package com.example.udemyslider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<imagefragments> fragments = new ArrayList<>();
    private ArrayList<String> titles =new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        titles.add("First");
        titles.add("Second");
        titles.add("Third");
        titles.add("Fourth");

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setFragments(ArrayList<imagefragments> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();

    }
}
