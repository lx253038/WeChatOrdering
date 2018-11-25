<html>
<head>
    <#include "../common/header.ftl">

    <script type="text/javascript">
        function imgChange() {
            document.getElementById("image").src = $("#productIcon").val();
        }
    </script>
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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <input type="hidden" name="productId" value="${(productInfo.productId)!""}">
                        <input type="hidden" class="form-control" name="createTime"
                               value="${(productInfo.createTime)!""}">

                        <div class="form-group">
                            <label>名称</label><input name="productName" type="text" class="form-control"
                                                    value="${(productInfo.productName)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label><input name="productPrice" type="text" class="form-control"
                                                    value="${(productInfo.productPrice)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label><input name="productStock" type="number" class="form-control"
                                                    value="${(productInfo.productStock)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label><input name="productDescription" type="text" class="form-control"
                                                    value="${(productInfo.productDescription)!""}"/>
                        </div>
                        <div class="form-group">

                            <label>图片</label>
                            <img id="image" width="200px" height="200px" style="margin-bottom: 12px"
                                 src="${(productInfo.productIcon)!""}">
                            <input id="productIcon" name="productIcon" type="text" class="form-control"
                                   value="${(productInfo.productIcon)!""}" onblur="imgChange()" onchange="imgChange()"/>
                        </div>
                        <div class="form-group">
                            <label>类别</label>
                            <select name="categoryType" class="form-control">
                                <#list listCategory as category>
                                    <option value="${category.categoryType}"
                                    <#if (productInfo.categoryType)?? && productInfo.categoryType==category.categoryType >
                                        selected
                                    </#if>
                                >${category.categoryName}</option>
                                </#list>

                            </select>
                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <select name="productStatus" class="form-control">
                                <option value="1"
                                        <#if (productInfo.productStatus)?? && productInfo.productStatus==1 >
                                            selected
                                        </#if>
                                >上架
                                </option>
                                <option value="0"
                                        <#if (productInfo.productStatus)?? && productInfo.productStatus==0 >
                                            selected
                                        </#if>
                                >下架
                                </option>
                            </select>
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