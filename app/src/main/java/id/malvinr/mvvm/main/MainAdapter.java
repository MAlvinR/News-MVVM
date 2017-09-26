package id.malvinr.mvvm.main;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.malvinr.mvvm.R;
import id.malvinr.mvvm.api.dao.NewsApiDao;
import id.malvinr.mvvm.databinding.ListRowBinding;

/**
 * Created by ASUS on 25/09/2017.
 */

public class MainAdapter extends GitsAdapter<NewsApiDao, MainRowVM, ListRowBinding> {

    public MainAdapter(List<NewsApiDao> data) {
        super(data);
    }

    @Override
    public MainRowVM createViewModel(AppCompatActivity activity, ListRowBinding binding, NewsApiDao item, int position) {
        return new MainRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_row;
    }

    @Override
    public void render(ListRowBinding binding, MainRowVM viewModel, NewsApiDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(NewsApiDao data, int position) {

    }

}
