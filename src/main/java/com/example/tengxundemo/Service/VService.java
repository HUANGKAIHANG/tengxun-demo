package com.example.tengxundemo.Service;

import com.example.tengxundemo.model.V;

import java.util.List;

public interface VService {

    public List<V> getVList();

    public void save(V v);
}
