#!/usr/bin/env bash


curl -H "Content-Type: application/json" -XPUT 0.0.0.0:9200/blogs -d '
{
    "settings": {
        "number_of_shards": 5,
        "number_of_replicas": 0
    }
}'
