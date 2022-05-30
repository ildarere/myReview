package com.lildar.myReview.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Date;

@Table("films")
public class Film implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;
    private String country;
    @Column("number_of_rated")
    private int numOfRated;
    @Column("sum_of_grades")
    private float sumOfGrades;
    private float rating;
    private Date date;


    public Film(int id, String name, String description, String country, int numOfRated, float sumOfGrades, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.numOfRated = numOfRated;
        this.sumOfGrades = sumOfGrades;
        this.date = date;
        this.rating = sumOfGrades/numOfRated;
    }

    public int getNumOfRated() {
        return numOfRated;
    }

    public void setNumOfRated(int numOfRated) {
        this.numOfRated = numOfRated;
    }

    public float getSumOfGrades() {
        return sumOfGrades;
    }

    public void setSumOfGrades(float sumOfGrades) {
        this.sumOfGrades = sumOfGrades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", numOfRated=" + numOfRated +
                ", sumOfGrades=" + sumOfGrades +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
