package com.xzf.service.impl;

import com.xzf.entity.Blog;
import com.xzf.mapper.BlogMapper;
import com.xzf.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzf
 * @since 2021-06-20
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
