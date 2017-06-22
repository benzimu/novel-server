<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>index</title>
</head>
<style>
    table {
        margin-top: 10px;
        border: 1px solid;
        border-collapse: collapse;
    }
    table th, table td {
        border: 1px solid;
        text-align: center;
    }
    .oddBg {
        background-color: #008200;
    }
    .evenBg {
        background-color: #677288;
    }
</style>
<body>
    <table>
        <tbody>
            <#list catalogList as catalog>
            <#--<#if catalog_index % 4-->
            <tr class=<#if catalog_index % 2 == 0>'oddBg'<#else>'evenBg'</#if>>
                <td>${catalog.id}</td>
                <td>${catalog.name!}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
