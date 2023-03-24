//package com.example.ncc1.service.product.impl;
//
//import com.example.ncc1.model.product.Toy;
//import com.example.ncc1.repository.product.ICartItemRepository;
//import com.example.ncc1.service.product.ICartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CartItemService implements ICartService {
//    @Autowired
//    private ICartItemRepository cartItemRepository;
//    @Override
//    public List<CartItem> getCartItems(int cartId) {
//        return cartItemRepository.findByCartId(cartId);
//    }
//
//    @Override
//    public void addToCart(int cartId, Toy toy, int quantity) {
//        CartItem cartItem = new CartItem();
//        cartItem.setToy(toy);
//        cartItem.setQuantity(quantity);
//        cartItem.setId(cartId);
//
//        cartItemRepository.save(cartItem);
//    }
//
//    @Override
//    public void updateCartItem(int cartItemId, int quantity) {
//        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
//        if (cartItemOptional.isPresent()){
//            CartItem cartItem = cartItemOptional.get();
//            cartItem.setQuantity(quantity);
//            cartItemRepository.save(cartItem);
//        }
//    }
//
//    @Override
//    public void removeCartItem(int cartItemId) {
//        cartItemRepository.deleteById(cartItemId);
//
//    }
//}
