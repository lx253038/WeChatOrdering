<html>
<head>
    <#include "../common/header.ftl">

    <style type="text/css">
        th {
            text-align: center;
        }

        td {
            vertical-align: middle;
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">


    <div id="page-content-wrapper">
        <#--正文内容-->
        <div class="container" style="width: 98%">
            <h2 align="center">卖家商品列表</h2>

            <div class="row clearfix">
                <div class="col-lg-12 ">
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                        <tr>
                            <th style="width: 180px">
                                商品Id
                            </th>
                            <th style="width: 160px">
                                商品图标
                            </th>
                            <th>
                                商品名称
                            </th>
                            <th>
                                商品类别
                            </th>
                            <th>
                                商品价格（元）
                            </th>
                            <th>
                                商品库存
                            </th>
                            <th>
                                商品描述
                            </th>
                            <th>
                                商品状态
                            </th>

                            <th colspan="3" style="text-align: center;">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list  productList.content as product>
                            <tr>
                            <td style="vertical-align: middle;width: 180px">
                            ${product.productId}
                            </td>
                            <td style="vertical-align: middle">
                        <img width="100px" height="100px" src="${product.productIcon}">
                            </td>
                            <td style="vertical-align: middle">
                            ${product.productName}
                            </td>
                            <td style="vertical-align: middle">
                            <#list listCategory as category>
                                <#if category.categoryType==product.categoryType>
                                    ${category.categoryName}
                                </#if>
                            </#list>

                            </td>
                            <td style="vertical-align: middle">
                            ${product.productPrice}
                            </td>
                            <td style="vertical-align: middle">
                            ${product.productStock}
                            </td>
                            <td style="vertical-align: middle;">
                            ${product.productDescription}
                            </td>
                            <#if product.productStatus==0>
                                <td style="vertical-align: middle;color: red"> 已下架</td>
                            </#if>
                            <#if product.productStatus==1>
                                <td style="vertical-align: middle;color: #4cae4c">已上架</td>
                            </#if>



                            <td style="vertical-align: middle;width: 80px">
                        <a   href="/sell/seller/product/index?productId=${product.productId}">修改</a>
                            </td>
                            <td style="vertical-align: middle;width: 80px">
                            <#if product.productStatus==0>
                                <a  href="/sell/seller/product/changeState?productId=${product.productId}">上架</a>
                            </#if>
                            <#if product.productStatus==1>
                                <a  href="/sell/seller/product/changeState?productId=${product.productId}">下架</a>
                            </#if>

                            </td>
                            <td style="vertical-align: middle;width: 80px">
                        <a   href="/sell/seller/product/delete?productId=${product.productId}">删除</a>
                            </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if nowPage==1>

                            <li class="disabled"><a href="">上一页</a></li>
                        <#else >
                            <li> <a href="/sell/seller/product/list?page=${nowPage-1}">上一页</a> </li>

                        </#if>
                        <#list 1..productList.getTotalPages() as index>

                            <#if index==nowPage>

                                <li class="disabled"> <a href="">${index}</a></li>
                            <#else >
                                <li> <a href="/sell/seller/product/list?page=${index}">${index}</a></li>

                            </#if>

                        </#list>
                        <#if nowPage==productList.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/product/list?page=${nowPage+1}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>