package id.malvinr.mvvm.main;

/**
 * Created by ASUS on 25/09/2017.
 */

public class DummyDao {
    public String dummyText;

    public DummyDao(String text) {
        this.dummyText = text;
    }

    public String getText() {
        return dummyText;
    }
}
