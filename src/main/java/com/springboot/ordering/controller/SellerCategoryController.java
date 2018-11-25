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
 * ���Ҷ���Ʒ������
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

    //��ҳ��ѯ������Ʒ���
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "3") Integer size, Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductCategory> pageCategory = categoryService.findAll(request);
        map.put("listCategory", pageCategory);
        map.put("nowPage", page);
        return new ModelAndView("category/list", map);
    }


    //�������޸���Ʒ���
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map) {
        ProductCategory category = new ProductCategory();
        if (categoryId != null) {
            category = categoryService.findOne(categoryId);
        }
        map.put("category", category);

        return new ModelAndView("category/edit", map);
    }

    //������Ʒ��Ϣ
    @PostMapping("/save")
    public ModelAndView save(ProductCategory category, Integer oldCategoryId, Map<String, Object> map) {
        if (category != null) {
            List<ProductCategory> list = categoryService.findByCategoryType(category.getCategoryType());

            if (oldCategoryId == null) {
                if (list != null && !list.isEmpty() && list.size() > 0) {
                    map.put("msg", "��������Ѵ��ڣ��޷����棡");
                    map.put("warning", "true");
                    map.put("url", "/sell/seller/category/list");
                    return new ModelAndView("common/infoMsg", map);
                }
                categoryService.save(category);
            } else {
                categoryService.save(category);
            }
            map.put("msg", "��Ʒ����ѱ���ɹ���");
            map.put("url", "/sell/seller/category/list");

        }

        return new ModelAndView("common/infoMsg", map);
    }

    //������Ʒ��Ϣ
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "categoryId") Integer categoryId, Map<String, Object> map) {
        ProductCategory category = categoryService.findOne(categoryId);
        List<ProductInfo> listProduct = productInfoService.findByCategoryType(category.getCategoryType());
        if (listProduct != null && !listProduct.isEmpty() && listProduct.size() > 0) {
            map.put("msg", "���������Ʒ���ڣ��޷�ɾ����");
            map.put("url", "/sell/seller/category/list");
            map.put("warning", "true");
            return new ModelAndView("common/infoMsg", map);

        }
        categoryService.delete(categoryId);
        map.put("msg", "��Ʒ����ѳɹ�ɾ����");
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/infoMsg", map);

    }
}
