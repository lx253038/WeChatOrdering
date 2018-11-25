package com.springboot.ordering.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
 * 卖家端商品管理
 *
 * @author LX
 * @date 2018-11-20 20:22
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    CategoryService categoryService;

    //分页查询所有商品
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "5") Integer size, Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> pageProductInfo = productInfoService.listAll(request);
        //查询所有类目
        List<ProductCategory> listCategory = categoryService.listAll();
        map.put("listCategory", listCategory);
        map.put("productList", pageProductInfo);
        map.put("nowPage", page);
        return new ModelAndView("product/list", map);
    }

    //上下架商品
    @GetMapping("/changeState")
    public ModelAndView changeState(@RequestParam(value = "productId") String productId, Map<String, Object> map) {
        ProductInfo productInfo = productInfoService.findOne(productId);
        if (productInfo.getProductStatus() == 0) {
            productInfo.setProductStatus(1);
            map.put("msg", "商品已成功上架！");
        } else if (productInfo.getProductStatus() == 1) {
            productInfo.setProductStatus(0);
            map.put("msg", "商品已成功下架！");
        }
        productInfoService.save(productInfo);
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);
    }

    //新增、修改商品
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String, Object> map) {
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)) {
            productInfo = productInfoService.findOne(productId);
        }
        map.put("productInfo", productInfo);
        //查询所有类目
        List<ProductCategory> listCategory = categoryService.listAll();
        map.put("listCategory", listCategory);
        return new ModelAndView("product/edit", map);
    }

    //保存商品信息
    @PostMapping("/save")
    public ModelAndView save(ProductInfo productInfo, Map<String, Object> map) {
        if (productInfo != null) {
            if (StringUtils.isEmpty(productInfo.getProductId())) {
                productInfo.setProductId(UUID.randomUUID().toString());
            }
            productInfoService.save(productInfo);
        }
        map.put("msg", "商品已保存成功！");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);
    }

    //保存商品信息
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "productId") String productId, Map<String, Object> map) {

        productInfoService.delete(productId);
        map.put("msg", "商品已成功删除！");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);

    }
}
