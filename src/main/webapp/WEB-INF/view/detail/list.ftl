<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>小说列表</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <table>
        <thead>
            <tr>
                <#--<th width="5%">id</th>-->
                <th width="10%">小说名</th>
                <th width="10%">作者</th>
                <th width="10%">小说更新时间</th>
                <th width="10%">状态</th>
                <th width="10%">类型</th>
                <th width="15%">来源</th>
                <#--<th>描述</th>-->
                <th width="20%">最新章节</th>
                <th width="10%">操作</th>
            </tr>
        </thead>
        <tbody>
            <#list novelDetailList as detail>
            <tr class=<#if detail_index % 2 == 0>'oddBg'<#else>'evenBg'</#if>>
                <#--<td>${detail.id}</td>-->
                <td>${detail.name!}</td>
                <td>${detail.author!}</td>
                <td>${detail.updateTime!}</td>
                <td>${detail.status!}</td>
                <td>${detail.type!}</td>
                <td>${detail.source!}</td>
                <#--<td>${detail.description}</td>-->
                <td>${detail.latestChapters!}</td>
                <td>
                    <a href="/chapters/catalog/${detail.id}">查看小说</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
