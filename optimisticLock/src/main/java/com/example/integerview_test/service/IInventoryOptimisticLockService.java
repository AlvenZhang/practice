package com.example.integerview_test.service;

import com.example.integerview_test.entity.InventoryOptimisticLock;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
@Service
public interface IInventoryOptimisticLockService extends IService<InventoryOptimisticLock> {

    InventoryOptimisticLock selectForUpdate(Integer id);

}
