package com.example.misbahulard.bottomnavigationexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.misbahulard.bottomnavigationexample.R;
import com.example.misbahulard.bottomnavigationexample.model.SegitigaSamaKaki;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaSamaKakiFragment extends Fragment {

    private CheckBox cbSisiMiring;
    private SegitigaSamaKaki segitigaSamaKaki;
    private TextInputEditText tietAlas, tietTinggi, tietSisiMiring;
    private TextInputLayout tilAlas, tilTinggi, tilSisiMiring;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        segitigaSamaKaki = new SegitigaSamaKaki();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segitiga_sama_kaki, container, false);

        cbSisiMiring = (CheckBox) view.findViewById(R.id.cb_sisi_miring);
        cbSisiMiring.setOnCheckedChangeListener(new SisiMiringCheckedChangeListener());

        tietAlas = (TextInputEditText) view.findViewById(R.id.tiet_alas);
        tietTinggi = (TextInputEditText) view.findViewById(R.id.tiet_tinggi);
        tietSisiMiring = (TextInputEditText) view.findViewById(R.id.tiet_sisi_miring);

        tilAlas = (TextInputLayout) view.findViewById(R.id.til_alas);
        tilTinggi = (TextInputLayout) view.findViewById(R.id.til_tinggi);
        tilSisiMiring = (TextInputLayout) view.findViewById(R.id.til_sisi_miring);

        view.findViewById(R.id.btn_keliling).setOnClickListener(new SamaKakiKelilingClickListener());
        view.findViewById(R.id.btn_luas).setOnClickListener(new SamaKakiLuasClickListener());

        return view;
    }

    private boolean isEmpty(String alas, String tinggi, String sisiMiring) {
        boolean isAlasEmpty = alas.isEmpty();
        boolean isTinggiEmpty = tinggi.isEmpty();
        boolean isSisiMiringEmpty = sisiMiring.isEmpty();
        boolean isNotSisiMiring = !cbSisiMiring.isChecked();

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

        if (!isNotSisiMiring && isSisiMiringEmpty) {
            tilSisiMiring.setErrorEnabled(true);
            tilSisiMiring.setError("Sisi miring tidak dapat kososng");
        } else
            tilSisiMiring.setErrorEnabled(false);

        return isAlasEmpty || isTinggiEmpty || (!isNotSisiMiring && isSisiMiringEmpty);
    }

    private void showResult(String result) {
        View view = getView();

        if (view != null)
            ((TextView) view.findViewById(R.id.tv_result)).setText(result);
    }

    private void clearText() {
        tietAlas.setText(null);
        tietTinggi.setText(null);
        tietSisiMiring.setText(null);
    }

    private class SisiMiringCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                tilSisiMiring.setVisibility(View.VISIBLE);
            else
                tilSisiMiring.setVisibility(View.GONE);

        }
    }

    private class SamaKakiKelilingClickListener implements SegitigaFragment.KelilingClickListener {

        @Override
        public void onClick(View v) {
            String alas = tietAlas.getText().toString();
            String tinggi = tietTinggi.getText().toString();
            String sisiMiring = tietSisiMiring.getText().toString();

            if (!isEmpty(alas, tinggi, sisiMiring)) {
                segitigaSamaKaki.setAlas(Double.parseDouble(alas));
                segitigaSamaKaki.setTinggi(Double.parseDouble(tinggi));

                if (cbSisiMiring.isChecked())
                    segitigaSamaKaki.setSisiMiring(Double.parseDouble(sisiMiring));
                else
                    segitigaSamaKaki.setSisiMiring();

                showResult(String.valueOf(segitigaSamaKaki.keliling()));
                clearText();
            }
        }
    }

    private class SamaKakiLuasClickListener implements SegitigaFragment.LuasClickListener {

        @Override
        public void onClick(View v) {
            String alas = tietAlas.getText().toString();
            String tinggi = tietTinggi.getText().toString();
            String sisiMiring = tietSisiMiring.getText().toString();

            if (!isEmpty(alas, tinggi, sisiMiring)) {
                segitigaSamaKaki.setAlas(Double.parseDouble(alas));
                segitigaSamaKaki.setTinggi(Double.parseDouble(tinggi));

                showResult(String.valueOf(segitigaSamaKaki.luas()));
                clearText();
            }
        }
    }
}
