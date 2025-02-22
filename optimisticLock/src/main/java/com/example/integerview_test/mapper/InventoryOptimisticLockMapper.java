package com.example.integerview_test.mapper;

import com.example.integerview_test.entity.InventoryOptimisticLock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
public interface InventoryOptimisticLockMapper extends BaseMapper<InventoryOptimisticLock> {

    InventoryOptimisticLock selectForUpdate(Integer id);
}

