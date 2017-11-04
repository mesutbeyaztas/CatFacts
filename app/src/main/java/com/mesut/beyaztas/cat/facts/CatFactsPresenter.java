package com.mesut.beyaztas.cat.facts;

import com.mesut.beyaztas.cat.facts.service.CatFactsResponse;
import com.mesut.beyaztas.cat.facts.service.CatFactsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesut on 02/11/2017.
 */

public class CatFactsPresenter implements CatFactsContract.Presenter {
    private final CatFactsContract.View catFactsView;
    private final CatFactsService catFactsService;

    CatFactsPresenter(CatFactsContract.View catFactsView) {
        this.catFactsView = catFactsView;
        this.catFactsService = new CatFactsService();
    }

    public void getCats(Integer limit, Integer maxLength) {
        catFactsView.hideKeyboard();
        catFactsView.showProgress();
        catFactsService
                .getAPI()
                .getCatFacts(limit, maxLength)
                .enqueue(new Callback<CatFactsResponse>() {
                    @Override
                    public void onResponse(Call<CatFactsResponse> call, Response<CatFactsResponse> response) {
                        catFactsView.hideProgress();
                        CatFactsResponse result = response.body();
                        if (result != null)
                            catFactsView.updateCatFactsAdapter(result.data);
                    }

                    @Override
                    public void onFailure(Call<CatFactsResponse> call, Throwable t) {
                        catFactsView.hideProgress();
                    }
                });
    }

}
