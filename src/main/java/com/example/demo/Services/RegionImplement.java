package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Region;
import com.example.demo.Repository.RegionRepository;

@Service
public class RegionImplement implements RegionService<Region>{

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Boolean Insert(Region model) {
        regionRepository.save(model);
        return regionRepository.findById(model.getRegionID()).isPresent();
    }

    @Override
    public Boolean Update(Region model) {
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Boolean Delete(int model) {
        regionRepository.deleteById(model);
        return !regionRepository.findById(model).isPresent();
    }

    @Override
    public Region Get(int model) {
        return regionRepository.findById(model).get();
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }
    
}
