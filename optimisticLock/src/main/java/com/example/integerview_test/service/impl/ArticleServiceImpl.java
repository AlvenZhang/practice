package com.example.integerview_test.service.impl;

import com.example.integerview_test.entity.Article;
import com.example.integerview_test.mapper.ArticleMapper;
import com.example.integerview_test.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
