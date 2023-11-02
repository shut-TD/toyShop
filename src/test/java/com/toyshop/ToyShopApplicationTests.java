package com.toyshop;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toyshop.Controller.utils.DateUtils;
import com.toyshop.Controller.utils.JWTUtils;
import com.toyshop.Controller.utils.R;
import com.toyshop.Controller.utils.RedisUtils;
import com.toyshop.Dao.*;
import com.toyshop.Entity.*;
import com.toyshop.Entity.TempEntity.DamSituation;
import com.toyshop.Entity.TempEntity.ProfitTop;
import com.toyshop.Service.serviceImpl.*;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ToyShopApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private userDao userDao;

    @Autowired
    private clerkDao clerkDao;

    @Autowired
    private registerImpl register;

    @Autowired
    private loginImpl loginimpl;

    @Autowired
    private clerkImpl clerkImpl;

    @Autowired
    private vipImpl vipImpl;

    @Autowired
    private vipDao vipDao;

    @Autowired
    private toyProductDao toyProductDao;

    @Autowired
    private toyProductImpl toyProductImpl;

    @Autowired
    private profitDao profitDao;

    @Autowired
    private profitImpl profitImpl;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private EchartsImpl echartsImpl;

    @Test
    void addVip(){
        Vip vip = new Vip();
        vip.setVipName("三歪");
        vip.setVipTag("会员");
        vip.setVipAddr("湖南省长沙市");
        vip.setVipDeposit(50);
        vip.setVipIntegral(200);
        vip.setVipPhone("16666666666");
        LocalDate date = LocalDate.parse("2020-08-07");
        vip.setVipDate(date);
        System.out.println(vipImpl.save(vip));
    }

    @Test
    void updateVip(){
        String vipId = "VIP@139436";
        LocalDate date = LocalDate.parse("2023-10-12");
        System.out.println(vipDao.updateVip(date,"","","",86,100,"",vipId));
    }

    @Test
    void delVip(){
        String vipId = "VIP@139436";
        System.out.println(vipDao.delVip(vipId));
    }

    @Test
    void listProduct(){
        System.out.println(toyProductDao.listToyproduct());
    }

    @Test
    void addToy(){
        for(int i = 0; i < 5; i++) {
            ToyProduct toyProduct = new ToyProduct();
            toyProduct.setToyName("小黑子");
            toyProduct.setPrice(666);
            toyProduct.setAnnexNumber(5);
            toyProduct.setBuytime(LocalDate.parse("2023-10-21"));
            toyProduct.setIsBroken("否");
            toyProduct.setDamSituation("无");
            System.out.println(toyProductDao.insertToy(toyProduct));
        }
    }

    @Test
    void delToy(){
        String toyId = "2b4d586f0b1340e49b6457204af3b925";
        System.out.println(toyProductDao.delToy(toyId));
    }

    @Test
    void saveprofit(){
        for(int i = 0; i < 4; i++) {
            Profit profit = new Profit();
            profit.setToyProfit(3000);
            profit.setToyId("dcd23a937e9d4afb8927e84539550302");
            profit.setToyName("ikun挂件");
            profit.setToyToClerk("三歪");
            profit.setClerkId("d6a24d0c2cf0b2fb131c2d57f9f1fefe");
            profit.setVipId("VIP@685173");
            profit.setVipName("三歪");
            profit.setStartDate(LocalDate.parse("2020-10-01"));
            profit.setEndDate(LocalDate.parse("2023-10-01"));
            System.out.println(profitImpl.save(profit));
        }
    }

    @Test
    void delByTradeid(){
        String id = "fa9d7c1aa42842398ba813959985f80e";
        System.out.println(profitDao.delByTradeId(id));
    }

    @Test
    void updatetoy(){
        ToyProduct toyProduct = new ToyProduct();
        toyProduct.setToyId("dcd23a937e9d4afb8927e84539550302");
        toyProduct.setToyName("小黑子");
        toyProduct.setPrice(888);
        toyProduct.setAnnexNumber(25);
        toyProductDao.updateToy(toyProduct);
//        toyProduct.setBuytime(LocalDate.parse("2023-10-01"));
//        toyProduct.setIsBroken("否");
//        toyProduct.setDamSituation("无");
    }

    @Test
    void updateProfit(){
        Profit profit = new Profit();
        profit.setTradeId("c956337e70db4b089156e94ba33242bf");
        profit.setToyProfit(2000);
        profit.setToyId("dcd23a937e9d4afb8927e84539550302");
        profit.setToyName("小鸡子");
//        profit.setToyToClerk("三歪");
        profit.setClerkId("d6a24d0c2cf0b2fb131c2d57f9f1fefe");
        profit.setVipId("VIP@799536");
        profit.setVipName("四歪");
        profit.setStartDate(LocalDate.parse("2020-10-01"));
        profit.setEndDate(LocalDate.parse("2023-10-01"));
        System.out.println(profitDao.updateProfit(profit));
    }

    @Test
    void getWeek(){
        System.out.println(dateUtils.getCurrentWeek());
    }

    @Test
    void getWeekIncome(){
        System.out.println(echartsImpl.getWeekIncome());
    }

    @Test
    void getTop(){
        List<ProfitTop> profitTop = profitDao.getTopProfit();
        for (ProfitTop p : profitTop){
            System.out.println(p.getToyName());
            System.out.println(p.getToyProfit());
        }
    }

    @Test
    void getTop3(){
        System.out.println(echartsImpl.getProfitTop());
    }

    @Test
    void getDam(){
        System.out.println(new R(200,echartsImpl.getDamCount()));
    }
//    @Test
//    void reg(){
//        User user = new User();
//        user.setUsername("yyy");
//        user.setPassword("lys666");
//        System.out.println(register.userRegister(user));
//    }
//
//    @Test
//    void login(){
//        String username = "admin";
//        String password = "123456";
//        System.out.println(loginimpl.userLogin(username,password));
//    }
//
//    @Test
//    void redidsSetValue() {
//        User user = new User();
//        user.setUsername("三歪");
//        user.setPassword("lys666");
//        user.setIsadmin(1);
//        Map<String,Object> usermap = new HashMap<>();
//        usermap.put(user.getUsername(), user);
//        String token = jwtUtils.createJwtToken(usermap);
//        redisUtils.set(user.getUsername(), (Object) token, 60L);
//        String userToken = (String) redisUtils.get(user.getUsername());
////        System.out.println(userToken);
//        Object checkToken = redisUtils.get(user.getUsername());
//        System.out.println(jwtUtils.verifyJwtToken((String) checkToken));
//    }
//
//    @Test
//    void checkToken(){
//        User user = new User();
//        user.setUsername("三歪");
//        user.setPassword("lys666");
//        user.setIsadmin(1);
////        System.out.println(loginimpl.userTokenCreate(user));
//        System.out.println(loginimpl.userTokenCheck(user));
//    }
//
    @Test
    void clerkInsert() throws ParseException {

            Clerk clerk = new Clerk();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate date = LocalDate.parse("2020-08-07");
            clerk.setClerkDate(date);
            clerk.setClerkName("三歪");
            System.out.println(clerkDao.insertClerk(clerk));

    }
//
//    @Test
//    void checkClerk(){
//        System.out.println(clerkDao.getAllClerk());
//    }
//
//    @Test
//    void updateClk(){
//        String clkId = "001";
//        LocalDate date = LocalDate.parse("2020-08-07");
//        System.out.println(clerkDao.updateClerk(clkId,date,"五歪"));
//    }
//
//    @Test
//    void deletClk(){
//        String clkId = "3ebb24202586c53bdbfc57f824bc7afa";
//        System.out.println(clerkDao.deleteByClerkId(clkId));
//    }
//
//    @Test
//    void page(){
//        Clerk clerk0 = new Clerk();
//        clerk0.setClerkName("三歪");
//        IPage<Clerk> page = clerkImpl.getPage(1,3);
//        System.out.println(new R(200,page.getRecords()));
//    }
//
//    @Test
//    void isExist(){
//        String username = "admin";
//        if (userDao.isExists(username) == null) System.out.println("not in");
//        else System.out.println("ok");
//    }
//
//    @Test
//    void insert(){
//        User user1 = new User();
//        user1.setUsername("三歪");
//        user1.setPassword("lys666");
//        user1.setImgName("");
//        user1.setIsadmin(1);
//        System.out.println(userDao.insertUser(user1));
//    }
//
//    @Test
//    void login(){
//        String username = "admin";
//        System.out.println(userDao.checkImg(username));
//    }
//
//    @Test
//    void update(){
//        String username = "admin";
//        System.out.println(userDao.updateInfo(username,"","/666"));
//    }
}
