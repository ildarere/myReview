package com.lildar.myReview.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("appeal")
public class Appeal {
    @Id
    private int id;
    @Column("id_post")
    private int postId;

    public Appeal(int id, int postId) {
        this.id = id;
        this.postId = postId;
    }
    public Appeal() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
