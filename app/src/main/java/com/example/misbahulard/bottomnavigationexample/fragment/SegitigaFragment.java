package com.example.misbahulard.bottomnavigationexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.misbahulard.bottomnavigationexample.R;

import java.util.ArrayList;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaFragment extends Fragment {

    private VPSegitigaAdapter fragmentPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentPagerAdapter = new VPSegitigaAdapter(getActivity().getSupportFragmentManager());
        fragmentPagerAdapter.addFragment(new SegitigaSamaSisiFragment(), "Segitiga Sama Sisi");
        fragmentPagerAdapter.addFragment(new SegitigaSamaKakiFragment(), "Segitiga Sama Kaki");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segitiga, container, false);

        TabLayout tlSegitiga = (TabLayout) view.findViewById(R.id.tl_segitiga);
        ViewPager vpSegitiga = (ViewPager) view.findViewById(R.id.vp_segitiga);

        vpSegitiga.setAdapter(fragmentPagerAdapter);
        tlSegitiga.setupWithViewPager(vpSegitiga);

        return view;
    }

    private class VPSegitigaAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments = new ArrayList<>();
        private ArrayList<String> fragmentTitles = new ArrayList<>();

        private VPSegitigaAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        private void addFragment(Fragment fragment, String fragmentTitle) {
            fragments.add(fragment);
            fragmentTitles.add(fragmentTitle);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }

    public interface KelilingClickListener extends View.OnClickListener {

    }

    public interface LuasClickListener extends View.OnClickListener {

    }
}
