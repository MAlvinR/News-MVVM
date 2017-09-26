package id.malvinr.mvvm.api;

import id.malvinr.mvvm.api.dao.NewsApiDao;
import id.malvinr.mvvm.api.dao.NewsListDao;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ASUS on 25/09/2017.
 */

public interface ApiInterface {
    @GET("articles")
    Observable<NewsListDao> getArticle(
      @Query("source") String source,
      @Query("sortBy") String soryBy,
      @Query("apiKey") String apiKey
    );
}
