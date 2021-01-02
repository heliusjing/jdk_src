package com.heliius.decorators;

/**
 * 定义了读取和写入操作的通用数据接口
 * @Author chengfei.jin
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
