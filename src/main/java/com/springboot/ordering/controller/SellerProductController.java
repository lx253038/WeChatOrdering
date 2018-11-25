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
 * ���Ҷ���Ʒ����
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

    //��ҳ��ѯ������Ʒ
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "5") Integer size, Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> pageProductInfo = productInfoService.listAll(request);
        //��ѯ������Ŀ
        List<ProductCategory> listCategory = categoryService.listAll();
        map.put("listCategory", listCategory);
        map.put("productList", pageProductInfo);
        map.put("nowPage", page);
        return new ModelAndView("product/list", map);
    }

    //���¼���Ʒ
    @GetMapping("/changeState")
    public ModelAndView changeState(@RequestParam(value = "productId") String productId, Map<String, Object> map) {
        ProductInfo productInfo = productInfoService.findOne(productId);
        if (productInfo.getProductStatus() == 0) {
            productInfo.setProductStatus(1);
            map.put("msg", "��Ʒ�ѳɹ��ϼܣ�");
        } else if (productInfo.getProductStatus() == 1) {
            productInfo.setProductStatus(0);
            map.put("msg", "��Ʒ�ѳɹ��¼ܣ�");
        }
        productInfoService.save(productInfo);
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);
    }

    //�������޸���Ʒ
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String, Object> map) {
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)) {
            productInfo = productInfoService.findOne(productId);
        }
        map.put("productInfo", productInfo);
        //��ѯ������Ŀ
        List<ProductCategory> listCategory = categoryService.listAll();
        map.put("listCategory", listCategory);
        return new ModelAndView("product/edit", map);
    }

    //������Ʒ��Ϣ
    @PostMapping("/save")
    public ModelAndView save(ProductInfo productInfo, Map<String, Object> map) {
        if (productInfo != null) {
            if (StringUtils.isEmpty(productInfo.getProductId())) {
                productInfo.setProductId(UUID.randomUUID().toString());
            }
            productInfoService.save(productInfo);
        }
        map.put("msg", "��Ʒ�ѱ���ɹ���");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);
    }

    //������Ʒ��Ϣ
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "productId") String productId, Map<String, Object> map) {

        productInfoService.delete(productId);
        map.put("msg", "��Ʒ�ѳɹ�ɾ����");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/infoMsg", map);

    }
}
