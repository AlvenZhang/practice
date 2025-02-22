package com.example.integerview_test.service.impl;

import com.example.integerview_test.entity.InventoryOptimisticLock;
import com.example.integerview_test.mapper.InventoryOptimisticLockMapper;
import com.example.integerview_test.service.IInventoryOptimisticLockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
@Service
public class InventoryOptimisticLockServiceImpl extends ServiceImpl<InventoryOptimisticLockMapper, InventoryOptimisticLock> implements IInventoryOptimisticLockService {

    @Autowired
    private InventoryOptimisticLockMapper inventoryOptimisticLockMapper;

    @Override
    public InventoryOptimisticLock selectForUpdate(Integer id) {
        return inventoryOptimisticLockMapper.selectForUpdate(id);
    }
}
