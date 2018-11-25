<html>
<head>
    <#include "../common/header.ftl">

    <style type="text/css">
        th {
            text-align: center;
        }

        td {
            text-align: center;
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
            <h2 align="center">卖家商品类别列表</h2>

            <div class="row clearfix">
                <div class="col-lg-12 ">
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                        <tr>
                            <th style="width: 180px">
                                类别Id
                            </th>
                            <th style="width: 160px">
                                类别名称
                            </th>
                            <th>
                                类别编号
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                修改时间
                            </th>

                            <th colspan="2" style="text-align: center;">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list  listCategory.content as category>
                            <tr>
                            <td > ${category.categoryId}</td>
                            <td>  ${category.categoryName} </td>
                            <td>  ${category.categoryType}  </td>
                            <td> ${category.createTime}  </td>
                            <td> ${category.updateTime} </td>
                            <td style="width: 80px;text-align: center">
                        <a  href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a>
                            </td>

                            <td style="width: 80px;text-align: center">
                        <a  href="/sell/seller/category/delete?categoryId=${category.categoryId}">删除</a>
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
                            <li> <a href="/sell/seller/category/list?page=${nowPage-1}">上一页</a> </li>

                        </#if>
                        <#list 1..listCategory.getTotalPages() as index>

                            <#if index==nowPage>

                                <li class="disabled"> <a href="">${index}</a></li>
                            <#else >
                                <li> <a href="/sell/seller/category/list?page=${index}">${index}</a></li>

                            </#if>

                        </#list>
                        <#if nowPage==listCategory.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/category/list?page=${nowPage+1}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>