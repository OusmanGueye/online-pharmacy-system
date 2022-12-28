package com.saraya.epharmacy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerManagements<T> {

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);

    void delete(int id);

    ResponseEntity<T> show(int id);

    ResponseEntity<List<T>> getAll();
}
