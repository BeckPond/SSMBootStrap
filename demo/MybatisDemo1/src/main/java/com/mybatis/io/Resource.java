package com.mybatis.io;

import java.io.InputStream;

public class Resource {
    public static InputStream getResourceAsStream(String filePath){
        return Resource.class.getClassLoader().getResourceAsStream(filePath);
    }
}
