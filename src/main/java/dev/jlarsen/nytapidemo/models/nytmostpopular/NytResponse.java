package dev.jlarsen.nytapidemo.models.nytmostpopular;

public class NytResponse {

    private String status;

    private String copyright;

    private int num_results;

    private Article[] results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public Article[] getResults() {
        return results;
    }

    public void setResults(Article[] results) {
        this.results = results;
    }

}
