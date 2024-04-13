package org.fwx.service.impl;

import org.fwx.dao.BookDao;
import org.fwx.dao.CustomerDao;
import org.fwx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 14:57
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CustomerDao customerDao;

    /*@Transactional(
           //readOnly = true
           //timeout = 3
           //noRollbackFor = ArithmeticException.class
           //noRollbackForClassName = "java.lang.ArithmeticException"
           //isolation = Isolation.DEFAULT
           // Propagation.REQUIRES_NEW 开启一个新的事务
           // Propagation.REQUIRES 默认值。使用之前的事务，类似购物时多个物品一起结账的功能
           propagation = Propagation.REQUIRES_NEW
   )*/
    @Transactional
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void buyBook(Integer userId,Integer bookId){
        // 获取书的价格
        int price = bookDao.getPrice(bookId);

        // 更新书的库存
        bookDao.updateBook(bookId);

        // 更新用户资金
        customerDao.updateCostomer(userId,price);

    }
}
