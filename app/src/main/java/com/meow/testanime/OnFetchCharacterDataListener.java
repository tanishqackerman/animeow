package com.meow.testanime;

import com.meow.testanime.ModelsCharacter.Data;

import java.util.List;

public interface OnFetchCharacterDataListener<CharAPIResponse> {
    void onFetchCharacterData(List<Data> list, String message);
    void onError(String message);
}
