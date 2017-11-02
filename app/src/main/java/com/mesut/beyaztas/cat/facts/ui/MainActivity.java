package com.mesut.beyaztas.cat.facts.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mesut.beyaztas.cat.facts.R;
import com.mesut.beyaztas.cat.facts.databinding.ActivityMainBinding;
import com.mesut.beyaztas.cat.facts.presenter.CatFactsPresenter;
import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CatFactsPresenter.CatFactsPresenterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        CatFactsPresenter catFactsPresenter = new CatFactsPresenter(this);
        catFactsPresenter.getCats(50, 50);
    }

    @Override
    public void catFactsReady(List<CatFactsResponse.Data> catFacts) {

    }
}
