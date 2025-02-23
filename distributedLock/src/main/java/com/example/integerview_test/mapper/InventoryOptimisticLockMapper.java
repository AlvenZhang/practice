package com.example.integerview_test.mapper;

import com.example.integerview_test.entity.InventoryOptimisticLock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
public interface InventoryOptimisticLockMapper extends BaseMapper<InventoryOptimisticLock> {

    InventoryOptimisticLock selectForUpdate(@Param("id") Integer id);
}

