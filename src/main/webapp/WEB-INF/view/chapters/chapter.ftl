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
    <h1>${chapter.name}</h1>
    <div class="content">
        ${chapter.content}
    </div>
</body>
</html>
