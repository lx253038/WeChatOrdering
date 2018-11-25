<html>
<head>
    <#include "../common/header.ftl">

    <style type="text/css">
        th {
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
            <h2 align="center">卖家订单列表</h2>

            <div class="row clearfix">
                <div class="col-lg-12 ">
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                        <tr>
                            <th>
                                订单Id
                            </th>
                            <th>
                                姓名
                            </th>
                            <th>
                                手机号
                            </th>
                            <th>
                                地址
                            </th>
                            <th>
                                金额（元）
                            </th>
                            <th>
                                订单状态
                            </th>
                            <th>
                                支付状态
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th colspan="2" style="text-align: center;">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list  orderList.content as orderDTO>
                            <tr>
                            <td>
                            ${orderDTO.orderId}
                            </td>
                            <td>
                            ${orderDTO.buyerName}
                            </td>
                            <td>
                            ${orderDTO.buyerPhone}
                            </td>
                            <td>
                            ${orderDTO.buyerAddress}
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
                            <td>
                            ${orderDTO.createTime}
                            </td>
                            <td style="text-align: center;width: 80px">
                        <a   href="/sell/seller/order/orderDetail?orderId=${orderDTO.orderId}">详情</a>
                            </td>
                            <td style="text-align: center;width: 80px">
                            <#if orderDTO.orderStatus==0>
                                <a  href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                            </#if>

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
                            <li> <a href="/sell/seller/order/list?page=${nowPage-1}">上一页</a> </li>

                        </#if>
                        <#list 1..orderList.getTotalPages() as index>

                            <#if index==nowPage>

                                <li class="disabled"> <a href="">${index}</a></li>
                            <#else >
                                <li> <a href="/sell/seller/order/list?page=${index}">${index}</a></li>

                            </#if>

                        </#list>
                        <#if nowPage==orderList.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${nowPage+1}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>