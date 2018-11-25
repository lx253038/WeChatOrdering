<html>
<head>
    <#include "header.ftl">

</head>
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "nav.ftl">


    <div id="page-content-wrapper">
        <#--正文内容-->
        <div style="width: 98%" class="container">
            <br>
            <br>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#if (warning) ?? && warning=="true" >
                        <div class="alert alert-dismissable alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            注意！
                        </h4> <strong>${msg}</strong><a id="success" href="${url}" class="alert-link"> 3s后自动跳转...</a>
                        </div>

                    <#else >
                        <div class="alert alert-dismissable alert-success">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            成功！
                        </h4> <strong>${msg}</strong><a id="success" href="${url}" class="alert-link"> 3s后自动跳转...</a>
                        </div>
                    </#if>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    setTimeout('location.href="${url}"', 3000);
</script>

</html>