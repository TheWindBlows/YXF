package com.yxf.demo.tool.api;

import com.alibaba.fastjson.JSON;
import com.yxf.demo.mode.entity.Order;
import com.yxf.demo.tool.result.ResultObject;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Description:ES操作Document的API
 * @author:yxf
 * @date:2020年4月9日
 */
@Component
public class ElasticSearchDocumentApi {

    @Resource
    private RestHighLevelClient client;

    // 设置默认超时时间 1秒
    private final TimeValue timeOut = TimeValue.timeValueSeconds(1);

    /**
     * @Description:创建文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject createDocument(Object object, String indexName, String documentId) throws IOException {
        // 获取对应的索引库
        IndexRequest request = new IndexRequest(indexName);
        // 设置id
        request.id(documentId);
        // 设置超时时间
        request.timeout(timeOut);
        // 将数据转为Json后放入ES中
        request.source(JSON.toJSONString(object), XContentType.JSON);
        // 发送请求
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        // 返回结果
        return new ResultObject().setResultData(response);
    }

    /**
     * @Description:查看文档是否存在
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public boolean existsDocument(String indexName, String documentId) throws IOException {
        // 获取对应的索引库
        GetRequest request = new GetRequest(indexName, documentId);
        // 不获取返回的 _Source 的上下文
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");
        // 返回结果
        return client.exists(request, RequestOptions.DEFAULT);
    }

    /**
     * @Description:获取文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject getDocument(String indexName, String documentId) throws IOException {
        // 获取对应的索引库
        GetRequest request = new GetRequest(indexName, documentId);
        // 发送获取请求
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        return new ResultObject().setResultData(response);
    }

    /**
     * @Description:修改文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject updateDocument(Object object, String indexName, String documentId) throws IOException {
        // 获取对应的索引库
        UpdateRequest request = new UpdateRequest(indexName, documentId);
        // 设置超时时间
        request.timeout(timeOut);
        // 将数据转为Json后放入ES中
        request.doc(JSON.toJSONString(object), XContentType.JSON);
        // 发送获取请求
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        return new ResultObject().setResultData(response);
    }

    /**
     * @Description:删除文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject deleteDocument(String indexName, String documentId) throws IOException {
        // 获取对应的索引库
        DeleteRequest request = new DeleteRequest(indexName, documentId);
        // 发送获取请求
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        return new ResultObject().setResultData(response);
    }

    /**
     * @Description:批量添加文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject createBulkDocument(List<Order> list, String indexName) throws IOException {
        // 获取对应的索引库
        BulkRequest request = new BulkRequest();
        for (Order order : list) {
            request.add(
                    new IndexRequest(indexName)
                    .source(JSON.toJSONString(order), XContentType.JSON));
        }
        // 发送获取请求
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        return new ResultObject().setResultData(response);
    }

    /**
     * @Description:搜索文档
     * @param:文档
     * @author:yxf
     * @date:2020年4月9日
     */
    public ResultObject searchDocument(String indexName, String searchName, String searchVaule) throws IOException {
        // 获取对应的索引库
        SearchRequest request = new SearchRequest(indexName);
        // 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 精确查询
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery(searchName,searchVaule);
        // 匹配所有
        // MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(queryBuilder);
        // 将搜索条件放入请求中
        request.source(sourceBuilder);
        // 发送获取请求
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        return new ResultObject().setResultData(response);
    }
}
