package com.yxf.demo;

import com.yxf.demo.mode.entity.Order;
import com.yxf.demo.tool.api.ElasticSearchDocumentApi;
import com.yxf.demo.tool.api.ElasticSearchIndexApi;
import com.yxf.demo.tool.result.ResultObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {

    @Resource
    ElasticSearchIndexApi indexApi;

    @Resource
    ElasticSearchDocumentApi documentApi;

    private String indexName = "yxf";

    @Test
    public void test() throws IOException {
        documentApi.deleteDocument(indexName,"2");
    }

    @Test
    public void test2() throws IOException {
        boolean b;
        ResultObject r;
        Order order;
        order = new Order().setOrderId("2").setName("ydf");
        r = documentApi.createDocument(order, indexName,"2");
        System.out.println("create = " + r.getResultData());
        b = documentApi.existsDocument(indexName,"2");
        System.out.println("exists = " + b);
        r = documentApi.getDocument(indexName,"2");
        System.out.println("get = " + r.getResultData());
        order = new Order().setOrderId("3").setName("ydf123");
        r = documentApi.updateDocument(order,indexName,"2");
        System.out.println("update = " + r.getResultData());
        List<Order> list = new ArrayList<Order>();
        list.add(new Order().setOrderId("11").setName("a"));
        list.add(new Order().setOrderId("12").setName("b"));
        list.add(new Order().setOrderId("13").setName("c"));
        r = documentApi.createBulkDocument(list,indexName);
        System.out.println("bulk = " + r.getResultData());
    }
}
