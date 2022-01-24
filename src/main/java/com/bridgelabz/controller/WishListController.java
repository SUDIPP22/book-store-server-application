package com.bridgelabz.controller;

import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.dto.WishlistDTO;
import com.bridgelabz.model.Wishlist;
import com.bridgelabz.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    private IWishlistService wishlistService;

    @GetMapping(value = "/details")
    public ResponseEntity<List<Wishlist>> getWishlist() {
        return new ResponseEntity<>(wishlistService.getAllWishlist(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addWishlist(@RequestBody WishlistDTO wishlistDTO) {
        return new ResponseEntity<>(wishlistService.addToWishlist(wishlistDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteWishlist(@PathVariable int wishlistID) {
        return new ResponseEntity<>(wishlistService.removeWishlist(wishlistID), HttpStatus.ACCEPTED);
    }
}
