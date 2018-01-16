# 小说web端服务器

## 项目简介
   此项目是为展示小说信息的web服务端。可以调用由python爬虫框架scrapy编写的爬虫项目，以爬取小说信息。
    
## 项目截图
   一、首页
   
   ![md-index](src/main/webapp/WEB-INF/static/images/md-index.png)
   
   二、小说目录页
   
   ![md-catalog](src/main/webapp/WEB-INF/static/images/md-catalog.png)
   
   &emsp;功能1：返回小说列表  
   &emsp;功能2：逆序显示  
   &emsp;功能3：运行爬虫服务端更新小说数据，爬虫服务器地址：[https://github.com/xiaoben67/novel](https://github.com/xiaoben67/novel)
   
   三、小说章节页
   
   ![md-chapter](src/main/webapp/WEB-INF/static/images/md-chapter.png)
    
   &emsp;功能1：上一篇  
   &emsp;功能2：返回目录  
   &emsp;功能3：下一篇  
    
## 项目环境
   项目是基于maven工具构建，使用springmvc4+hibernate4框架，数据库为mysql5.7，系统为Ubuntu16.10    
   
   使用IDEA构建项目：首先Fork项目，然后运行File --> New --> Project from Version Control --> GitHub
   
## 项目运行方法
   一、本地运行

   1. git clone https://github.com/xiaoben67/novel-server.git
   2. cd novel-server
   3. git submodule init
   4. git submodule update
   5. 修改数据库链接：novel-server/src/main/resources/properties/config.properties
   6. 项目的script有数据库sql文件，需要初始化。具体使用可查看：[https://github.com/xiaoben67/novel/blob/piaotian/README.md](https://github.com/xiaoben67/novel/blob/piaotian/README.md)
   7. 安装Python环境（参考 novel-server/novel/README.md）
   8. 修改novel-server/src/main/resources/properties/novel.properties
   
   二、Docker
   
   1. git clone https://github.com/xiaoben67/novel-server.git
   2. 修改数据库链接：novel-server/src/main/resources/properties/config.properties
   3. cd novel-server
   4. 制作镜像：docker build -t novel-server:1.0 .
   5. 或者直接拉取镜像： docker pull benlee/novel-server:1.0
   5. docker run -d --name novel-server -p 8080:8080 --hostname novel-server --env DB_USER=root --env DB_PASSWD=hjj --env DB_NAME=novel --env DB_HOST=172.24.6.177 --env DB_PORT=3306 novel-server:1.0
   
