package com.lg.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin
 * @ClassName HttpController
 * @date 2018/9/3 13:05
 * @description
 **/

@Controller
public class HttpController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @GetMapping("/index")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/allOrder")
    public String getQueryPage(){
        return "allOrder";
    }

    @GetMapping("/finishedOrder")
    public String getQuery1Page(){ return "finishedOrder"; }

    @GetMapping("/unfinishedOrder")
    public String getQuery2Page(){ return "unfinishedOrder"; }

    @GetMapping(value = "navigation")
    public String getNavigationPage(){
        return "navigation";
    }

    @GetMapping(value = "/dispatch")
    public String getDispatchPage(){
        return "dispatch";
    }



    @GetMapping(value = "/queryWarehouse")
    public String getQueryWarePage(){
        return "queryWarehouse";
    }


    @GetMapping(value = "/addWarehouse")
    public String getAddyWarePage(){
        return "addWarehouse";
    }

    @GetMapping(value = "/queryAllGoods")
    public String getQueryGoodsPage(){
        return "queryAllGoods";
    }

    @GetMapping(value = "/addGoods")
    public String getAddGoodsPage(){
        return "addGoods";
    }

    @GetMapping(value = "/OrderByID")
    public String getOrderByIDPage(){return "OrderByID";}

    @GetMapping(value = "/deleteOrder")
    public String getDeleteOrderPage(){return "deleteOrder";}

    @GetMapping(value = "/addOrder")
    public String getAddOrderPage(){return "addOrder";}

    @GetMapping(value = "/queryWareGoods")
    public String getWareGoodsPage(){
        return "queryWareGoods";
    }

    @GetMapping(value = "/adminNavi")
    public String getAdminPage(){
        return "adminNavi";
    }

    @GetMapping(value = "/deleteEmployee")
    public String getDeleteEmployeePage(){
        return "deleteEmployee";
    }

    @GetMapping(value = "/allEmployee")
    public String getAllEmployeePage(){
        return "allEmployee";
    }


}
