package com.mesut.beyaztas.cat.facts.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mesut.beyaztas.cat.facts.R;
import com.mesut.beyaztas.cat.facts.databinding.ActivityMainBinding;
import com.mesut.beyaztas.cat.facts.presenter.CatFactsPresenter;
import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CatFactsPresenter.CatFactsPresenterListener, View.OnClickListener {

    private ActivityMainBinding binding;
    private CatFactsPresenter catFactsPresenter;
    private CatFactsRecyclerAdapter catFactsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        catFactsPresenter = new CatFactsPresenter(this);
        binding.catFactsSearchView.setOnClickListener(this);
    }

    @Override
    public void catFactsReady(List<CatFactsResponse.Data> catFacts) {
        if (catFactsRecyclerAdapter == null) {
            catFactsRecyclerAdapter = new CatFactsRecyclerAdapter(catFacts);
            binding.catFactsRecyclerView.setAdapter(new CatFactsRecyclerAdapter(catFacts));
        } else {
            catFactsRecyclerAdapter.updateItems(catFacts);
            catFactsRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        int randomNumber = catFactsPresenter.getRandomNumber();
        String maxLength = binding.catFactsEditText.getText().toString().trim();
        catFactsPresenter.getCats(randomNumber, Integer.valueOf(maxLength));
    }
}
