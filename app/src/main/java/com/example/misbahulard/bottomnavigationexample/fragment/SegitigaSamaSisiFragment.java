package com.example.misbahulard.bottomnavigationexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.misbahulard.bottomnavigationexample.R;
import com.example.misbahulard.bottomnavigationexample.model.SegitigaSamaSisi;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaSamaSisiFragment extends Fragment {

    private SegitigaSamaSisi segitigaSamaSisi;
    private TextInputEditText tietAlas, tietTinggi;
    private TextInputLayout tilAlas, tilTinggi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        segitigaSamaSisi = new SegitigaSamaSisi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segitiga_sama_sisi, container, false);

        tietAlas = (TextInputEditText) view.findViewById(R.id.tiet_alas);
        tietTinggi = (TextInputEditText) view.findViewById(R.id.tiet_tinggi);

        tilAlas = (TextInputLayout) view.findViewById(R.id.til_alas);
        tilTinggi = (TextInputLayout) view.findViewById(R.id.til_tinggi);

        view.findViewById(R.id.btn_keliling).setOnClickListener(new SamaSisiKelilingClickListener());
        view.findViewById(R.id.btn_luas).setOnClickListener(new SamaSisiLuasClickListener());

        return view;
    }

    private boolean isEmpty(String alas, String tinggi) {
        boolean isAlasEmpty = alas.isEmpty();
        boolean isTinggiEmpty = tinggi.isEmpty();

        if (isAlasEmpty) {
            tilAlas.setErrorEnabled(true);
            tilAlas.setError("Alas tidak dapat kosong");
        } else
            tilAlas.setErrorEnabled(false);

        if (isTinggiEmpty) {
            tilTinggi.setErrorEnabled(true);
            tilTinggi.setError("Tinggi tidak dapat kosong");
        } else
            tilTinggi.setErrorEnabled(false);

        return isAlasEmpty || isTinggiEmpty;
    }

    private void showResult(String result) {
        View view = getView();

        if (view != null)
            ((TextView) view.findViewById(R.id.tv_result)).setText(result);
    }

    private void clearText() {
        tietAlas.setText(null);
        tietTinggi.setText(null);
    }

    private class SamaSisiKelilingClickListener implements SegitigaFragment.KelilingClickListener {

        @Override
        public void onClick(View v) {
            String alas = tietAlas.getText().toString();
            String tinggi = tietTinggi.getText().toString();

            if (!isEmpty(alas, tinggi)) {
                segitigaSamaSisi.setAlas(Double.parseDouble(alas));
                segitigaSamaSisi.setTinggi(Double.parseDouble(tinggi));

                showResult(String.valueOf(segitigaSamaSisi.keliling()));
                clearText();
            }
        }
    }

    private class SamaSisiLuasClickListener implements SegitigaFragment.LuasClickListener {

        @Override
        public void onClick(View v) {
            String alas = tietAlas.getText().toString();
            String tinggi = tietTinggi.getText().toString();

            if (!isEmpty(alas, tinggi)) {
                segitigaSamaSisi.setAlas(Double.parseDouble(alas));
                segitigaSamaSisi.setTinggi(Double.parseDouble(tinggi));

                showResult(String.valueOf(segitigaSamaSisi.luas()));
                clearText();
            }
        }
    }
}
