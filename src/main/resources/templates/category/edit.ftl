<html>
<head>
    <#include "../common/header.ftl">

</head>
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">


    <div id="page-content-wrapper">
        <#--正文内容-->
        <div class="container" style="width: 98%">
            <br>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <input type="hidden" name="oldCategoryId" value="${(category.categoryId)!""}">
                        <input type="hidden" name="categoryId" value="${(category.categoryId)!""}">
                        <input type="hidden" name="createTime" value="${(category.createTime)!""}">
                        <div class="form-group">

                            <label>类别编号</label>
                            <input name="categoryType" type="number" class="form-control"
                                   value="${(category.categoryType)!""}"
                                    <#if (category.categoryId)??>
                                        readonly="readonly"
                                    </#if>

                            />
                        </div>

                        <div class="form-group">
                            <label>类别名称</label>
                            <input name="categoryName" type="text" class="form-control"
                                   value="${(category.categoryName)!""}"/>
                        </div>

                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>