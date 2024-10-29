package ru.netology.controller;

import com.google.gson.Gson;
//import jakarta.servlet.http.HttpServletResponse;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public class PostController {
    public static final String APPLICATION_JSON = "application/json";
    private final PostService service;
    private final Gson gson = new Gson();

    public PostController(PostService service) {
        this.service = service;
    }

    public void all(HttpServletResponse response) throws IOException {
        final var data = service.all();
        handleResponse(response, data);
    }

    public void getById(long id, HttpServletResponse response) throws IOException {
        // TODO: deserialize request & serialize response
        final var data = service.getById(id);
        handleResponse(response, data);
    }

    public void save(Reader body, HttpServletResponse response) throws IOException {
        final var post = gson.fromJson(body, Post.class);
        final var data = service.save(post);
        handleResponse(response, data);
    }

    public void removeById(long id, HttpServletResponse response) throws IOException {
        // TODO: deserialize request & serialize response
        service.removeById(id);
        handleResponse(response, SC_OK);
    }

    private void handleResponse(HttpServletResponse response, Object data) throws IOException {
        response.setContentType(APPLICATION_JSON);
        response.getWriter().print(gson.toJson(data));
    }
}
