package com.lildar.myReview.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("review")
public class Review {
    @Id
    private int id;
    private String text;
    private int idAuthor;
    private int idFilm;
    private String nameAuthor;
    private String nameReview;

    public Review(int id, String text, int idAuthor, int idFilm, String nameAuthor, String nameReview) {
        this.id = id;
        this.text = text;
        this.idAuthor = idAuthor;
        this.idFilm = idFilm;
        this.nameAuthor = nameAuthor;
        this.nameReview = nameReview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getNameReview() {
        return nameReview;
    }

    public void setNameReview(String nameReview) {
        this.nameReview = nameReview;
    }

    public String getLittleText(){
        if(text.length()<=80){
            return text;
        }
        return text.substring(0,80);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", idAuthor=" + idAuthor +
                ", idFilm=" + idFilm +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", nameReview='" + nameReview + '\'' +
                '}';
    }
}
