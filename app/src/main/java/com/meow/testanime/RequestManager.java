package com.meow.testanime;

import android.content.Context;
import android.widget.Toast;

import com.meow.testanime.ModelsAnime.AnimeAPIResponse;
import com.meow.testanime.ModelsCharacter.CharAPIResponse;
import com.meow.testanime.ModelsManga.MangaAPIResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getAnimeTop(OnFetchDataListener listener) {
        CallAnimeAPITop callAnimeAPITop = retrofit.create(CallAnimeAPITop.class);
        Call<AnimeAPIResponse> callTop = callAnimeAPITop.callTopAnime();

        try {
            callTop.enqueue(new Callback<AnimeAPIResponse>() {
                @Override
                public void onResponse(Call<AnimeAPIResponse> call, Response<AnimeAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<AnimeAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnimeSearch(OnFetchDataListener listener, String query) {
        CallAnimeAPISearch callAnimeAPISearch = retrofit.create(CallAnimeAPISearch.class);
        Call<AnimeAPIResponse> callSearch = callAnimeAPISearch.callSearchAnime(query, context.getString(R.string.api_key));

        try {
            callSearch.enqueue(new Callback<AnimeAPIResponse>() {
                @Override
                public void onResponse(Call<AnimeAPIResponse> call, Response<AnimeAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<AnimeAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMangaTop(OnFetchMangaDataListener listener) {
        CallMangaAPITop callMangaAPITop = retrofit.create(CallMangaAPITop.class);
        Call<MangaAPIResponse> callTop = callMangaAPITop.callTopManga();

        try {
            callTop.enqueue(new Callback<MangaAPIResponse>() {
                @Override
                public void onResponse(Call<MangaAPIResponse> call, Response<MangaAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchMangaData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<MangaAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMangaSearch(OnFetchMangaDataListener listener, String query) {
        CallMangaAPISearch callMangaAPISearch = retrofit.create(CallMangaAPISearch.class);
        Call<MangaAPIResponse> callSearch = callMangaAPISearch.callSearchManga(query);

        try {
            callSearch.enqueue(new Callback<MangaAPIResponse>() {
                @Override
                public void onResponse(Call<MangaAPIResponse> call, Response<MangaAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchMangaData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<MangaAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCharTop(OnFetchCharacterDataListener listener) {
        CallCharAPITop callCharAPITop = retrofit.create(CallCharAPITop.class);
        Call<CharAPIResponse> callTop = callCharAPITop.callTopChar();

        try {
            callTop.enqueue(new Callback<CharAPIResponse>() {
                @Override
                public void onResponse(Call<CharAPIResponse> call, Response<CharAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchCharacterData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<CharAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCharSearch(OnFetchCharacterDataListener listener, String query) {
        CallCharAPISearch callCharAPISearch = retrofit.create(CallCharAPISearch.class);
        Call<CharAPIResponse> callSearch = callCharAPISearch.callSearchChar(query);

        try {
            callSearch.enqueue(new Callback<CharAPIResponse>() {
                @Override
                public void onResponse(Call<CharAPIResponse> call, Response<CharAPIResponse> response) {
                    if (!response.isSuccessful()) Toast.makeText(context, "Meowrror!!", Toast.LENGTH_SHORT).show();

                    listener.onFetchCharacterData(response.body().getData(), response.message());
                }

                @Override
                public void onFailure(Call<CharAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface CallAnimeAPITop {
        @GET("top/anime")
        Call<AnimeAPIResponse> callTopAnime();
    }

    public interface CallAnimeAPISearch {
        @GET("anime")
        Call<AnimeAPIResponse> callSearchAnime(
                @Query("q") String animeName,
                @Query("apiKey") String apikey
        );
    }

    public interface CallMangaAPITop {
        @GET("top/manga")
        Call<MangaAPIResponse> callTopManga();
    }

    public interface CallMangaAPISearch {
        @GET("manga")
        Call<MangaAPIResponse> callSearchManga(
                @Query("q") String animeName
        );
    }

    public interface CallCharAPITop {
        @GET("top/characters")
        Call<CharAPIResponse> callTopChar();
    }

    public interface CallCharAPISearch {
        @GET("characters")
        Call<CharAPIResponse> callSearchChar(
                @Query("q") String animeName
        );
    }
}
