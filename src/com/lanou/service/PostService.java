package com.lanou.service;

import com.lanou.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface PostService {

    List<Post> findAll();

    Post findById(int pid);
}
