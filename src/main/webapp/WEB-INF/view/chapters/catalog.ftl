<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>小说章节目录</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <div>
        <a class="back-a" title="小说列表" href="/detail/list">←</a>
        <a class="reverse-a" title="逆序" href="/chapters/catalog/${novelDetail.id}?reverseFlag=${reverseFlag}">⇅</a>
        <a class="back-a" title="运行爬虫" href="/chapters/catalog/${novelDetail.id}?reverseFlag=<#if reverseFlag == 0>1<#else>0</#if>&crawlFlag=1">⇣</a>
        <h1>
        ${novelDetail.name}&nbsp;&nbsp;•&nbsp;&nbsp;${novelDetail.author}
        </h1>
    </div>
    <table>
        <#list catalogList?chunk(4) as catalogs>
        <tr class=<#if catalogs_index % 2 == 0>'oddBg'<#else>'evenBg'</#if>>
            <#list catalogs as catalog>
                <td><a href="/chapters/${catalog.id}">${catalog.name!}</a></td>
            </#list>
        </tr>
        </#list>
    </table>
</body>
</html>
