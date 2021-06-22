package com.xzf.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzf.config.component.CustomReturnProfile;
import com.xzf.config.component.ShiroUtils;
import com.xzf.entity.Blog;
import com.xzf.entity.CommonResult;
import com.xzf.service.IBlogService;
import com.xzf.service.impl.BlogServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzf
 * @since 2021-06-20
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private IBlogService blogService;

    @RequiresAuthentication
    @GetMapping(value = "{id}")
    @ApiOperation(value = "测试一")
    public Object testCon(@PathVariable Long id){
        return blogService.getById(id);
    }

    @GetMapping("/blogs")
    @ApiOperation(value = "获取列表")
    public CommonResult blogs(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return CommonResult.success("success",pageData);
    }


    @RequiresAuthentication
    @PostMapping("/blog/edit")
    @ApiOperation(value = "编辑")
    public CommonResult edit(@Validated @RequestBody Blog blog) {
        System.out.println(blog.toString());
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            Assert.isTrue(temp.getUserId() == ShiroUtils.getProfile().getId(), "没有权限编辑");
        } else {
            temp = new Blog();
            temp.setUserId(ShiroUtils.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        return CommonResult.success("操作成功", null);
    }








}
