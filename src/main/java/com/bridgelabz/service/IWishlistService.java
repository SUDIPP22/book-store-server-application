package com.bridgelabz.service;

import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.dto.WishlistDTO;
import com.bridgelabz.model.Wishlist;

import java.util.List;

public interface IWishlistService {
    List<Wishlist> getAllWishlist();

    ResponseDTO addToWishlist(WishlistDTO wishlistDTO);

    ResponseDTO removeWishlist(int wishlistID);
}
