package com.example.ncc1.controller.product;

import com.example.ncc1.dto.product.ToyDTO;
import com.example.ncc1.service.product.IToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Page<ToyDTO> showAll(@RequestParam (name = "name",required = false,defaultValue = "")String name, @PageableDefault(size = 3) Pageable pageable){
        return toyService.showAll(name,pageable);
    }
@ResponseStatus(HttpStatus.OK)
@GetMapping("/{id}")
public ToyDTO findById(@PathVariable int id){
        return toyService.findById(id);
}
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveToy(@RequestBody ToyDTO toyDTO) {
      toyService.save(toyDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable int id) {
        toyService.deleteToy(id);
    }

    //    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
   public void update(@PathVariable int id,@RequestBody ToyDTO toyDTO){
        ToyDTO toyDTO1 = toyService.findById(id);
        toyDTO.setId(id);
        toyService.save(toyDTO);
    }
}

