package com.meow.testanime;

import com.meow.testanime.ModelsManga.Data;

import java.util.List;

public interface OnFetchMangaDataListener<MangaAPIResponse> {
    void onFetchMangaData(List<Data> list, String message);
    void onError(String message);
}
