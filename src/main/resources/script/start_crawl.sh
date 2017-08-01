#!/bin/sh
# 切换到爬虫项目根目录下
cd $1
# 由于执行爬虫有大量日志输出会导致进程hang住，所以将其输出到/dev/null
# scrapy框架安装环境
$2 $1/novel/main.py > /dev/null 2>&1 &