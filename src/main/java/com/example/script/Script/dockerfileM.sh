#!/usr/bin/env bash
#echo "ppap" \
# > /Users/joyyue/IdeaProjects/HunterBoot4/src/main/java/com/example/script/Script/ppap.txt
# 第一个docker执行脚本，运行一个elasticsearch脚本

#docker run -d --name elasticsearch --net somenetwork -p \
#9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:tag

# docker 中的 elasticsearch 启动脚本 v2
# 带有 es 的 name 标识的脚本
name=$1
docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9200:9200 -p 9300:9300 --name ${name} \
  elasticsearch:6.5.4

echo "successfully start elasticsearch:${name}"
