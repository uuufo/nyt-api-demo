package dev.jlarsen.nytapidemo.models.nytsearch;

public class Response {

    private Doc[] docs;

    public Doc[] getDocs() {
        return docs;
    }

    public void setDocs(Doc[] docs) {
        this.docs = docs;
    }
}
