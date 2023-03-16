package com.example.ncc1.repository;

import com.example.ncc1.model.supplier.SupplierType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierTypeService extends JpaRepository<SupplierType,Integer> {
}
