package com.mesut.beyaztas.cat.facts;

import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;

import java.util.List;

public interface CatFactsContract {

    interface View {
        void updateCatFactsAdapter(List<CatFactsResponse.Data> catFacts);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void getCats(Integer limit, Integer maxLength);
    }

}