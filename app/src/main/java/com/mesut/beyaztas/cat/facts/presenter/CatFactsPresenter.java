package com.mesut.beyaztas.cat.facts.presenter;

import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;
import com.mesut.beyaztas.cat.facts.service.CatFactsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesut on 02/11/2017.
 */

public class CatFactsPresenter {
    private final CatFactsPresenterListener catFactsPresenterListener;
    private final CatFactsService catFactsService;

    public interface CatFactsPresenterListener {
        void catFactsReady(List<CatFactsResponse.Data> catFacts);
    }

    public CatFactsPresenter(CatFactsPresenterListener catFactsPresenterListener) {
        this.catFactsPresenterListener = catFactsPresenterListener;
        this.catFactsService = new CatFactsService();
    }

    public void getCats(Integer limit, Integer maxLength) {
        catFactsService
                .getAPI()
                .getCatFacts(limit, maxLength)
                .enqueue(new Callback<CatFactsResponse>() {
                    @Override
                    public void onResponse(Call<CatFactsResponse> call, Response<CatFactsResponse> response) {
                        CatFactsResponse result = response.body();
                        if (result != null)
                            catFactsPresenterListener.catFactsReady(result.data);
                    }

                    @Override
                    public void onFailure(Call<CatFactsResponse> call, Throwable t) {

                    }
                });
    }
}
