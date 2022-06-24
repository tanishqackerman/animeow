package com.meow.testanime;

public interface SelectListener {
    void OnAnimeClicked(com.meow.testanime.ModelsAnime.Data data);
    void OnMangaClicked(com.meow.testanime.ModelsManga.Data data);
    void OnCharacterClicked(com.meow.testanime.ModelsCharacter.Data data);
}
