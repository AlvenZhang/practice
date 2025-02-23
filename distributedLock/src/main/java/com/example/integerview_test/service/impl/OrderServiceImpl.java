package com.example.integerview_test.service.impl;

import com.example.integerview_test.entity.Order;
import com.example.integerview_test.mapper.OrderMapper;
import com.example.integerview_test.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xifeng
 * @since 2025-02-19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
