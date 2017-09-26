package id.malvinr.mvvm.main;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.malvinr.mvvm.api.dao.NewsApiDao;
import id.malvinr.mvvm.databinding.ListRowBinding;

/**
 * Created by ASUS on 25/09/2017.
 */

public class MainRowVM extends GitsRowVM<NewsApiDao, ListRowBinding> {
    public ObservableField<String> bTextJudul = new ObservableField<>();
    public ObservableField<String> bTextTanggal = new ObservableField<>();
    public ObservableField<String> bUrlImage = new ObservableField<>();

    private static final  SimpleDateFormat formatTo =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
    private static final  SimpleDateFormat formatFrom =
            new SimpleDateFormat("MMMMMMMM dd, yyyy", Locale.getDefault());

    public MainRowVM(Context context, ListRowBinding binding, NewsApiDao data) {
        super(context, binding, data);
        bTextJudul.set(data.getTitle());
        bUrlImage.set(data.getUrlToImage());
        formatDate(data);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public void formatDate(NewsApiDao data) {
        try
        {
            bTextTanggal.set(formatFrom.format(formatTo.parse(data.getPublishedAt())));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }



    }
}
