package com.springboot.ordering.form;

import org.hibernate.validator.constraints.NotEmpty;


public class CategoryForm {

    /**
     * 类目id.
     */
    private Integer categoryId;
    /**
     * 类目名称
     */
    @NotEmpty(message = "类目名称不能为空")
    private String categoryName;

    /**
     * 类目类别
     */
    private Integer categoryType;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
