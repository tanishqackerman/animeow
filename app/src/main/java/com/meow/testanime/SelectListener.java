package com.meow.testanime;

public interface SelectListener {
    void OnAnimeClicked(com.meow.testanime.ModelsAnime.Data data);
    void OnMangaClicked(com.meow.testanime.ModelsManga.Data data);
    void OnCharacterClicked(com.meow.testanime.ModelsCharacter.Data data);
    void OnMangaClicked(com.meow.testanime.DBModels.MangaDB mangaDB);
    void OnAnimeClicked(com.meow.testanime.DBModels.AnimeDB animeDB);
    void OnCharacterClicked(com.meow.testanime.DBModels.CharDB data);
}
