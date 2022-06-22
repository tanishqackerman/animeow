package com.meow.testanime;

import android.content.Context;
import android.widget.Toast;

import com.meow.testanime.Models.AnimeAPIResponse;

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
}
