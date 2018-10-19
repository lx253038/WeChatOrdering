package com.springboot.ordering.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ordering.VO.ProductInfoVo;
import com.springboot.ordering.VO.ProductVo;
import com.springboot.ordering.VO.ResultVo;
import com.springboot.ordering.model.ProductCategory;
import com.springboot.ordering.model.ProductInfo;
import com.springboot.ordering.service.CategoryService;
import com.springboot.ordering.service.ProductInfoService;
import com.springboot.ordering.utils.ResultVoUtil;

@RestController
@RequestMapping("/buyer/product")
public class ProductController {
    @Autowired
    ProductInfoService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {
        //查询所有上架的商品
        List<ProductInfo> products = productService.findByProductStatus(1);

        //查询所有类目
        List<Integer> typeNumList = new ArrayList<>();

        for (ProductInfo pi : products) {
            typeNumList.add(pi.getCategoryType());
        }
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(typeNumList);

        //数据拼装
        List<ProductVo> productVoList = new ArrayList<>();//包含商品类目list

        for (ProductCategory category : categoryList) {
            List<ProductInfoVo> infoList = new ArrayList<>(); //商品详细信息list
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(category.getCategoryName());
            productVo.setCategoryType(category.getCategoryType());
            for (ProductInfo info : products) {
                if (info.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVo vo = new ProductInfoVo();
                    BeanUtils.copyProperties(info, vo);
                    infoList.add(vo);
                }
            }

            productVo.setProductInfoVoList(infoList);
            productVoList.add(productVo);
        }


        return ResultVoUtil.success(productVoList);
    }
}
