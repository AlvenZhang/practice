package com.example.integerview_test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.integerview_test.entity.InventoryOptimisticLock;
import com.example.integerview_test.entity.Order;
import com.example.integerview_test.mapper.InventoryOptimisticLockMapper;
import com.example.integerview_test.service.IInventoryOptimisticLockService;
import com.example.integerview_test.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import static com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.Prefix.one;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
@RestController
@RequestMapping("/inventoryOptimisticLock")
public class InventoryOptimisticLockController {

    private static final Logger log = LoggerFactory.getLogger(InventoryOptimisticLockController.class);

    @Autowired
    private IInventoryOptimisticLockService inventoryOptimisticLockService;

    @Autowired
    private IOrderService orderService;


    // 下单接口
    @Transactional(propagation = Propagation.REQUIRED)
    @GetMapping("/order/{courseId}")
    public String placeOrder(@PathVariable("courseId") Integer courseId) {
        // 1. 获取数据库中库存信息
        InventoryOptimisticLock one = inventoryOptimisticLockService.selectOne(courseId);
        boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        // 2. 进行库存扣减
        if (one.getNums() > 0) {
            actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            UpdateWrapper<InventoryOptimisticLock> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("nums", one.getNums() - 1);
            updateWrapper.set("version", one.getVersion() + 1);
            updateWrapper.eq("version", one.getVersion());
            updateWrapper.eq("id", one.getId());
            boolean update = inventoryOptimisticLockService.update(updateWrapper);
            while (!update) {
                log.warn("版本不正确，开始重试。。。。");
                one = inventoryOptimisticLockService.selectOne(courseId);

                if (one.getNums() <= 0) {
                    log.info("商品库存不足");
                    return "商品库存不足";
                }
                updateWrapper = new UpdateWrapper<>();
                updateWrapper.set("nums", one.getNums() - 1);
                updateWrapper.set("version", one.getVersion() + 1);
                updateWrapper.eq("version", one.getVersion());
                updateWrapper.eq("id", one.getId());
                update = inventoryOptimisticLockService.update(updateWrapper);
            }
            log.info("库存扣减成功，订单创建中。当前version={}",one.getVersion());
            // 3. 创建订单逻辑
            Order order = Order.builder().userId(new Random().nextInt()).price(one.getPrice()).articleId(courseId).addTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).status(1).build();
            boolean save = orderService.save(order);
            log.info("订单创建成功");
        } else {
            log.info("商品库存不足");
            return "商品库存不足";
        }
        return "购买成功，等待跳转支付页面。。。。";
    }

}
