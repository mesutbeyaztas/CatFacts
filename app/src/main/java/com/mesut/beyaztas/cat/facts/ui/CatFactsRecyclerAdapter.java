package com.mesut.beyaztas.cat.facts.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mesut.beyaztas.cat.facts.R;
import com.mesut.beyaztas.cat.facts.databinding.ItemCatFactsBinding;
import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;

import java.util.List;

/**
 * Created by Mesut on 02/11/2017.
 */

public class CatFactsRecyclerAdapter extends RecyclerView.Adapter<CatFactsRecyclerAdapter.CatFactsViewHolder> {

    private List<CatFactsResponse.Data> catFacts;

    CatFactsRecyclerAdapter(List<CatFactsResponse.Data> catFacts) {
        this.catFacts = catFacts;
    }

    @Override
    public CatFactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemCatFactsBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_cat_facts, parent, false);
        return new CatFactsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CatFactsViewHolder holder, int position) {
        holder.bind(catFacts.get(position));
    }

    void updateItems(List<CatFactsResponse.Data> catFacts) {
        this.catFacts = catFacts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return catFacts.size();
    }

    static class CatFactsViewHolder extends RecyclerView.ViewHolder {

        private final ItemCatFactsBinding binding;

        CatFactsViewHolder(ItemCatFactsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CatFactsResponse.Data catFact) {
            binding.setCatFact(catFact);
            binding.executePendingBindings();
        }
    }

}
