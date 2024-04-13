package org.fwx.controller;

import org.fwx.service.BookService;
import org.fwx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 14:43
 * @Version 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkout(Integer userId, Integer[] bookIds){
        checkoutService.checkout(userId, bookIds);
    }
}
