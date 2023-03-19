package com.example.ncc1.controller;

import com.example.ncc1.model.Toy;
import com.example.ncc1.model.TypeOfToy;
import com.example.ncc1.model.dto.ToyDTO;
import com.example.ncc1.service.product.IToyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ToyRestfulController {
    @Autowired
    private IToyService toyService;

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping ("/toy")
//    public ResponseEntity<List<Toy>> getAll(){
//        List<Toy> toys = toyService.showAll();
//        if (toys.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }else {
//            return new ResponseEntity<>(toys,HttpStatus.OK);
//        }
//    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<ToyDTO> showAll(@RequestParam (name = "name",required = false,defaultValue = "")String name,@PageableDefault(size = 3) Pageable pageable){
        return toyService.showAll(name,pageable);
    }
@ResponseStatus(HttpStatus.OK)
@GetMapping("/{id}")
public ToyDTO findById(@PathVariable int id){
        return toyService.findById(id);
}
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveToy(@RequestBody ToyDTO toyDTO) {
      toyService.save(toyDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void  deleteToy(@RequestParam(required = false) Integer id) {
        toyService.deleteToy(id);
    }

    //    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editToy(@RequestBody ToyDTO toyDTO) {
        Toy toy = new Toy();
        BeanUtils.copyProperties(toyDTO,toy);
        toy.setTypeOfToy(new TypeOfToy(toyDTO.getTypeToyDTO().getId()));
        toyService.editToy(toy);
    }
}

