package com.example.ncc1.controller;

import com.example.ncc1.model.supplier.Supplier;
import com.example.ncc1.model.supplier.SupplierType;
import com.example.ncc1.repository.ISupplierTypeService;
import com.example.ncc1.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {
        @Autowired
    private ISupplierTypeService supplierTypeService;
    @Autowired
    private ISupplierService iSupplierService;

    @GetMapping("")
    public ResponseEntity<Page<Supplier>> list(Model model , @PageableDefault(size = 2) Pageable pageable) {
        Page<Supplier> supplierList = iSupplierService.findAll(pageable);
        if (supplierList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierList,HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Supplier> delete(@PathVariable int id, Model model) {
        Optional<Supplier> supplierOptional = iSupplierService.findById(id);
        if (supplierOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSupplierService.deleteById(id);
        return new ResponseEntity<>(supplierOptional.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/create")
    public String showFormCreate(Model model ){
        List<SupplierType> supplierTypeList = supplierTypeService.findAll();
        model.addAttribute("supplierTypeList",supplierTypeList);
        model.addAttribute("supplier",new Supplier());
        return "views/create";
    }

}
