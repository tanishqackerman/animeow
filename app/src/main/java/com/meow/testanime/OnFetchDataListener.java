package com.meow.testanime;

import com.meow.testanime.ModelsAnime.Data;

import java.util.List;

public interface OnFetchDataListener<AnimeAPIResponse>{
    void onFetchData(List<Data> list, String message);
    void onError(String message);
}
