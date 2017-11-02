package com.mesut.beyaztas.cat.facts.service;

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

    public static class Data {
        public String fact;
        public int length;
    }
}
