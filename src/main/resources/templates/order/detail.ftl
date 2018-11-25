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
            <h2 align="center">订单详情</h2>

            <div class="row clearfix">
                <div class="col-lg-6 ">

                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                订单Id
                            </th>

                            <th>
                                订单总金额（元）
                            </th>
                            <th>
                                订单状态
                            </th>
                            <th>
                                支付状态
                            </th>

                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td>
                                ${orderDTO.orderId}
                            </td>
                            <td>
                                ${orderDTO.orderAmount}
                            </td>
                            <td>
                                <#if orderDTO.orderStatus==0>
                                    新订单
                                </#if>
                                <#if orderDTO.orderStatus==1>
                                    订单完成
                                </#if>
                                <#if orderDTO.orderStatus==2>
                                    订单取消
                                </#if>
                            </td>
                            <td>
                                <#if orderDTO.payStatus==0>
                                    未支付
                                </#if>
                                <#if orderDTO.payStatus==1>
                                    已支付
                                </#if>

                            </td>

                        </tr>

                        </tbody>
                    </table>
                </div>
                <br>
                <div class="col-lg-12 ">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th style="width: 30%">
                                商品Id
                            </th>
                            <th>
                                商品名称
                            </th>
                            <th>
                                价格（元）
                            </th>
                            <th>
                                数量
                            </th>
                            <th>
                                总额（元）
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        <#list  orderDetails as detail>
                            <tr>
                            <td>
                            ${detail.detailId}
                            </td>
                            <td>
                            ${detail.productName}
                            </td>
                            <td>
                            ${detail.productPrice}
                            </td>
                            <td>
                            ${detail.productQuantity}
                            </td>
                            <td>
                            ${detail.productPrice*detail.productQuantity}
                            </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>


                <div style="text-align: right" class="col-md-12 column">
                    <#if orderDTO.orderStatus==0>
                        <a style="margin-left: 15px" class="btn btn-default btn-primary" href="/sell/seller/order/orderFinish?orderId=${orderDTO.orderId}">完结订单</a>
                        <a style="margin-left: 15px" class="btn btn-default btn-danger" href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消订单</a>
                    </#if>
                    <a style="margin-left: 15px" class="btn btn-default btn-success" href="/sell/seller/order/list">&nbsp;返回&nbsp;</a>
                </div>


            </div>
        </div>
    </div>
</div>
</body>

</html>