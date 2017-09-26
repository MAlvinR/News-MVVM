package id.malvinr.mvvm.api.dao;

import java.util.List;

/**
 * Created by ASUS on 25/09/2017.
 */

public class BaseApiDao <T> {
    private String status;
    private String source;
    private String sortBy;
    private List<T> articles;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<T> getArticles() {
        return articles;
    }
}
