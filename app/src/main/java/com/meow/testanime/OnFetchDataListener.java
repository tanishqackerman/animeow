package com.meow.testanime;

import com.meow.testanime.Models.Data;

import java.util.List;

public interface OnFetchDataListener<AnimeAPIResponse>{
    void onFetchData(List<Data> list, String message);
    void onError(String message);
}
