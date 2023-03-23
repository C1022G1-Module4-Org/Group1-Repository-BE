package com.example.ncc1.dto.product;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ToyDTO, Integer> toyMap = new HashMap<>();

    public Map<ToyDTO, Integer> getToyMap() {
        return toyMap;
    }

    public void setToyMap(Map<ToyDTO, Integer> toyMap) {
        this.toyMap = toyMap;
    }

    public CartDTO() {
    }

    public CartDTO(Map<ToyDTO, Integer> toyMap) {
        this.toyMap = toyMap;
    }
    public void addToy(ToyDTO toyDTO){
        if (toyMap.containsKey(toyDTO)){
            Integer currentValue = toyMap.get(toyDTO);
            toyMap.replace(toyDTO,currentValue + 1);
        }else {
            toyMap.put(toyDTO,1);
        }
    }

    public void decrease(ToyDTO toyDTO){
        if (toyMap.containsKey(toyDTO)){
            Integer currentValue = toyMap.get(toyDTO);
            toyMap.replace(toyDTO, currentValue - 1);
        }
        if (toyMap.get(toyDTO) <= 0){
            toyMap.remove(toyDTO);
        }
    }
    public void remove(ToyDTO toyDTO){
        toyMap.remove(toyDTO);
    }

    public double payTotal(){
        double sum = 0;
        for (Map.Entry<ToyDTO, Integer> entry : toyMap.entrySet()){
            sum += entry.getValue() * entry.getKey().getPrice();
        }
        return sum;
    }
}
