#!/bin/sh
cd /home/ben/workspace_mg/novel
# 由于执行爬虫有大量日志输出会导致进程hang住，所以将其输出到/dev/null
/home/ben/virtualenv/scripy/bin/python2.7 /home/ben/workspace_mg/novel/novel/main.py > /dev/null 2>&1 &