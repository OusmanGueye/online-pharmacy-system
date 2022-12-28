package com.saraya.epharmacy.service;

import java.util.List;

public interface ServiceManagements<E, D> {

    D save(D d);

    void deleteById(int id);

    D findById(int id);

    List<D> findAll();

    D update(D d);
}
