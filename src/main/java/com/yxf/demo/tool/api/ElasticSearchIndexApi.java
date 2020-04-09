package com.yxf.demo.tool.api;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:ES操作Index的API
 * @author:yxf
 * @date:2020年4月9日
 */
@Component
public class ElasticSearchIndexApi {

    @Resource
    private RestHighLevelClient client;

    /**
     * @Description:创建索引
     * @param:索引名称
     * @author:yxf
     * @date:2020年4月9日
     */
    public boolean createIndex(String indexName) throws IOException {
        // 判断索引是否存在
        if (this.existsIndex(indexName)) {
            return true;
        }
        // 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        // 客户端执行创建请求
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        // 返回结果值
        return response.isAcknowledged();
    }

    /**
     * @Description:查看索引是否存在
     * @param:索引名称
     * @author:yxf
     * @date:2020年4月9日
     */
    public boolean existsIndex(String indexName) throws IOException {
        // 获取索引请求
        GetIndexRequest request = new GetIndexRequest(indexName);
        // 客户端执行查询请求
        return client.indices().exists(request,RequestOptions.DEFAULT);
    }

    /**
     * @Description:删除索引
     * @param:索引名称
     * @author:yxf
     * @date:2020年4月9日
     */
    public boolean deleteIndex(String indexName) throws IOException {
        // 判断索引是否存在
        if (!this.existsIndex(indexName)) {
            return true;
        }
        // 获取索引请求
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        // 客户端执行查询请求
        AcknowledgedResponse response = client.indices().delete(request,RequestOptions.DEFAULT);
        // 返回结果值
        return response.isAcknowledged();
    }
}
