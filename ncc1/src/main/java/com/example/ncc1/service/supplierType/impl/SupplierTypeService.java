package com.example.ncc1.service.supplierType.impl;

import com.example.ncc1.model.supplier.SupplierType;
import com.example.ncc1.service.supplierType.ISupplierTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierTypeService implements ISupplierTypeService {
    @Autowired
    private ISupplierTypeService supplierTypeService;
    @Override
    public List<SupplierType> findAll() {
        return supplierTypeService.findAll();
    }
}
