<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>小说目录</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <div>
        <div>
        <#if lastChapter??>
            <a class="back-a" title="上一篇" href="/chapters/${lastChapter.id}">←</a>
        <#else>
            <a class="back-a">←</a>
        </#if>
            <a class="catalog-a" title="目录" href="/chapters/catalog/${chapter.novelDetailId}">↞</a>
        <#if nextChapter??>
            <a class="next-a" title="下一篇" href="/chapters/${nextChapter.id}">→</a>
        <#else>
            <a class="next-a">→</a>
        </#if>
            <h1>${chapter.name}</h1>
        </div>
        <div class="content">${chapter.content}</div>
    </div>

</body>
</html>
