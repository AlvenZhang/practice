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
@RequestMapping("/inventoryDistributed")
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
        // 1. 获取分布式锁


        // 2. 修改库存 & 创建订单


    }

}
