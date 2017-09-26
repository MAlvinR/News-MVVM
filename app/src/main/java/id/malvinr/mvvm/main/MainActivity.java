package id.malvinr.mvvm.main;

import id.gits.mvvmcore.activity.GitsActivity;
import id.malvinr.mvvm.R;
import id.malvinr.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends GitsActivity<MainActivityVM, ActivityMainBinding> {

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }
}
