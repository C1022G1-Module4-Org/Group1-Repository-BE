package com.example.ncc1.controller.product;

import com.example.ncc1.model.product.Toy;
import com.example.ncc1.service.product.IToyService;
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

@RestController
@RequestMapping("/toy")
@CrossOrigin("*")
public class ToyRestfulController {
    @Autowired
    private IToyService toyService;

    @GetMapping ("/")
    public ResponseEntity<List<Toy>> getAll(){
        List<Toy> toys = toyService.showAll();
        if (toys.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(toys,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getDetailBlog(@PathVariable int id){
        Toy toy = toyService.findById(id);
        if (toy == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(toy,HttpStatus.OK);
        }
    }
    @GetMapping("/find-typeOfToy/{id}")
    public ResponseEntity<Page<Toy>> getToyByCategory(@PathVariable int id, Pageable pageable){
        Page<Toy> toys = toyService.findByTypeOfToy(id, pageable);
        if (toys == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(toys,HttpStatus.OK);
        }
    }
    @GetMapping("/toys")
    public String showLists(Model model, @RequestParam(required = false,defaultValue = "")String nameSearch, @PageableDefault(size = 2,page = 0,sort = "date",direction = Sort.Direction.ASC) Pageable pageable){
        Page<Toy> toyList = toyService.findByNameContaining(nameSearch,pageable);
        model.addAttribute("toyList",toyList);
        model.addAttribute("nameSearch",nameSearch);
        if (toyService.showAll().isEmpty()){
            model.addAttribute("mess","List is Empty");
        }
        return "/list";
    }
}
