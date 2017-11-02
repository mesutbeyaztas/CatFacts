package com.mesut.beyaztas.cat.facts.service;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mesut.beyaztas.cat.facts.BR;

import java.util.List;

/**
 * Created by Mesut on 02/11/2017.
 */

public class CatFactsResponse {
    public int total;
    public String per_page;
    public int current_page;
    public int last_page;
    public String next_page_url;
    public String prev_page_url;
    public int from;
    public int to;
    public List<Data> data;

    public static class Data extends BaseObservable {
        public String fact;
        public int length;

        @Bindable
        public String getFact() {
            return fact;
        }

        public void setFact(String fact) {
            this.fact = fact;
            notifyPropertyChanged(BR.catFact);
        }
    }
}
