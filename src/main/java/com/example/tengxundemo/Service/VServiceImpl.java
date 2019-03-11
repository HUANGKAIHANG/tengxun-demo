package com.example.tengxundemo.Service;

import com.example.tengxundemo.Repository.VRepository;
import com.example.tengxundemo.model.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VServiceImpl implements VService{

    @Autowired
    private VRepository vRepository;

    @Override
    public List<V> getVList() {
        return vRepository.findAll();
    }

    @Override
    public void save(V v) {
        vRepository.save(v);
    }
}
