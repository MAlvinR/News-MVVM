package id.malvinr.mvvm.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.malvinr.mvvm.api.ApiClient;
import id.malvinr.mvvm.api.dao.NewsApiDao;
import id.malvinr.mvvm.api.dao.NewsListDao;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS on 25/09/2017.
 */

public class MainActivityVM extends GitsVM {

    private final List<NewsApiDao> mList = new ArrayList<>();
    public LinearLayoutManager layoutManager;
    public MainAdapter bAdapter;

    public MainActivityVM(final Context context) {
        super(context);

        /*mList.add(new DummyDao("Lorem Ipsum"));
        mList.add(new DummyDao("Dolor Sit amet"));
        mList.add(new DummyDao("This is a simple MVVM"));
        mList.add(new DummyDao("Using Gits Library"));
        mList.add(new DummyDao("Say Hello to MVVM!!"));*/

        bAdapter = new MainAdapter(mList);
        layoutManager = new LinearLayoutManager(mContext);
        callApi();
    }

    private void callApi() {
        addSubscription(ApiClient.getInstance()
                .getEndpoint()
                .getArticle(
                        "bbc-sport",
                        "top",
                        "b6bf62b52cd24eeab8dacde9ebb9a700")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<NewsListDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(NewsListDao newsListDao) {
                        mList.addAll(newsListDao.getArticles());
                        bAdapter.notifyDataSetChanged();
                    }
                }));
    }


}
