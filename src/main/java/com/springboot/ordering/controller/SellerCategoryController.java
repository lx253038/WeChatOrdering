package com.springboot.ordering.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ordering.model.ProductCategory;
import com.springboot.ordering.model.ProductInfo;
import com.springboot.ordering.service.CategoryService;
import com.springboot.ordering.service.ProductInfoService;

/**
 * 卖家端商品类别管理
 *
 * @author LX
 * @date 2018-11-20 20:22
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    CategoryService categoryService;

    //分页查询所有商品类别
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "3") Integer size, Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductCategory> pageCategory = categoryService.findAll(request);
        map.put("listCategory", pageCategory);
        map.put("nowPage", page);
        return new ModelAndView("category/list", map);
    }


    //新增、修改商品类别
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map) {
        ProductCategory category = new ProductCategory();
        if (categoryId != null) {
            category = categoryService.findOne(categoryId);
        }
        map.put("category", category);

        return new ModelAndView("category/edit", map);
    }

    //保存商品信息
    @PostMapping("/save")
    public ModelAndView save(ProductCategory category, Integer oldCategoryId, Map<String, Object> map) {
        if (category != null) {
            List<ProductCategory> list = categoryService.findByCategoryType(category.getCategoryType());

            if (oldCategoryId == null) {
                if (list != null && !list.isEmpty() && list.size() > 0) {
                    map.put("msg", "该类别编号已存在，无法保存！");
                    map.put("warning", "true");
                    map.put("url", "/sell/seller/category/list");
                    return new ModelAndView("common/infoMsg", map);
                }
                categoryService.save(category);
            } else {
                categoryService.save(category);
            }
            map.put("msg", "商品类别已保存成功！");
            map.put("url", "/sell/seller/category/list");

        }

        return new ModelAndView("common/infoMsg", map);
    }

    //保存商品信息
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "categoryId") Integer categoryId, Map<String, Object> map) {
        ProductCategory category = categoryService.findOne(categoryId);
        List<ProductInfo> listProduct = productInfoService.findByCategoryType(category.getCategoryType());
        if (listProduct != null && !listProduct.isEmpty() && listProduct.size() > 0) {
            map.put("msg", "该类别有商品存在，无法删除！");
            map.put("url", "/sell/seller/category/list");
            map.put("warning", "true");
            return new ModelAndView("common/infoMsg", map);

        }
        categoryService.delete(categoryId);
        map.put("msg", "商品类别已成功删除！");
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/infoMsg", map);

    }
}
