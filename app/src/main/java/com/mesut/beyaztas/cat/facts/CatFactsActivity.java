package com.mesut.beyaztas.cat.facts;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mesut.beyaztas.cat.facts.databinding.ActivityCatFactsBinding;
import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;
import com.mesut.beyaztas.cat.facts.utils.NumberUtils;

import java.util.List;

public class CatFactsActivity extends AppCompatActivity implements CatFactsContract.View, View.OnClickListener {

    private ActivityCatFactsBinding binding;
    private CatFactsPresenter catFactsPresenter;
    private CatFactsRecyclerAdapter catFactsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_facts);

        catFactsPresenter = new CatFactsPresenter(this);
        binding.catFactsSearchView.setOnClickListener(this);
    }

    @Override
    public void updateCatFactsAdapter(List<CatFactsResponse.Data> catFacts) {
        if (catFactsRecyclerAdapter == null) {
            catFactsRecyclerAdapter = new CatFactsRecyclerAdapter(catFacts);
            binding.catFactsRecyclerView.setAdapter(catFactsRecyclerAdapter);
        } else {
            catFactsRecyclerAdapter.updateItems(catFacts);
            catFactsRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showProgress() {
        binding.catFactsProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.catFactsProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        int randomNumber = NumberUtils.getRandomNumber();
        String maxLength = binding.catFactsEditText.getText().toString().trim();
        catFactsPresenter.getCats(randomNumber, Integer.valueOf(maxLength));
    }
}