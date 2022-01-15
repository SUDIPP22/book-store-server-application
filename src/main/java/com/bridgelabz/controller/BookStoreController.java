package com.bridgelabz.controller;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.JWTRequest;
import com.bridgelabz.dto.JWTResponse;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.service.BookStoreService;
import com.bridgelabz.service.UserService;
import com.bridgelabz.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book-store")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/details")
    public ResponseEntity<ResponseDTO> addNewBook(
            @Valid
            @RequestBody BookDetailsDTO bookDetailsDTO
    ) {
        return new ResponseEntity<>(bookStoreService.addNewBook(bookDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/details")
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>(bookStoreService.getAllBookDetails(), HttpStatus.OK);
    }

    @GetMapping(value = "/fetch-details")
    public ResponseEntity<ResponseDTO> saveBookDataFromCSV() {
       return new ResponseEntity<>(bookStoreService.saveBookData(),HttpStatus.OK);
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<Book> getBookDetailsById(
            @PathVariable int id
    ) {
        return new ResponseEntity<>(bookStoreService.findBookDetailsById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/authenticate")
    public JWTResponse authenticate(
            @RequestBody JWTRequest jwtRequest
            ) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException exception) {
            throw new Exception("INVALID CREDENTIALS", exception);
        }
        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUserName());

        final String token = jwtUtility.generateToken(userDetails);

        return new JWTResponse(token);
    }
}
