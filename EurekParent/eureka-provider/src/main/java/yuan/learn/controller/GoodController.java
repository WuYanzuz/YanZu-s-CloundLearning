package yuan.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yuan.learn.pojo.Goods;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/6/21 16:45
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@RestController
public class GoodController {

    @GetMapping("pro/{id}")
    public Goods getGood(@PathVariable("id") Integer id){
        Goods goods = new Goods();
        goods.setId(id);
        return goods;
    }
}
