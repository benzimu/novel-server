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
            <a class="back-a" title="上一篇" href="/chapters/catalog/${chapter.novelDetailId}">←</a>
            <a class="catalog-a" title="目录" href="/chapters/catalog/${chapter.novelDetailId}">↞</a>
            <a class="next-a" title="下一篇" href="/chapters/catalog/${chapter.novelDetailId}">→</a>
            <h1>${chapter.name}</h1>
        </div>
        <div class="content">${chapter.content}</div>
    </div>

</body>
</html>
