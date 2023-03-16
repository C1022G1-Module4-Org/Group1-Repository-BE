package com.example.ncc1.service.supplier.impl;

import com.example.ncc1.model.supplier.Supplier;
import com.example.ncc1.repository.ISupplierRepository;

import com.example.ncc1.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class SupplierService implements ISupplierService {
    @Autowired
    ISupplierRepository supplierRepository;

    @Override
    public Page<Supplier> findAll(Pageable pageable) {

        return supplierRepository.findAll(pageable);
    }

    @Override
    public Optional<Supplier> deleteById(int id) {
        supplierRepository.deleteById(id);
        return null;
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> listSearchByName(String name) {
        return supplierRepository.listSearchByName(name);
    }
}
