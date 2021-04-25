package dev.jlarsen.nytapidemo.models.nytsearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.jlarsen.nytapidemo.models.nytmostpopular.Media;

import java.util.Date;

public class Doc {

    @JsonProperty("web_url")
    private String url;

    @JsonProperty("news_desk")
    private String newsDesk;

    @JsonProperty("section_name")
    private String section;

    private Byline byline;

    private Headline headline;

    @JsonProperty("abstract")
    private String summary;

    private Media[] multimedia;

    private Date pub_date;

    private String imageUrl;

    public Doc(String url, String section, String newsDesk, Byline byline, Headline headline, String summary, Media[] multimedia, Date pub_date, String imageUrl) {
        this.url = url;
        this.section = section;
        this.newsDesk = newsDesk;
        this.byline = byline;
        this.headline = headline;
        this.summary = summary;
        this.multimedia = multimedia;
        this.pub_date = pub_date;
        this.imageUrl = imageUrl;
    }

    public Doc(Headline headline) {
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Media[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Media[] multimedia) {
        this.multimedia = multimedia;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
