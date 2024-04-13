package org.fwx;

import org.fwx.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName D02TxAnnotationTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 15:02
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class D02TxAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void txAnnotationTest(){
//        bookController.buyBook(1,1);
        bookController.checkout(1, new Integer[]{1,2});
    }
}
