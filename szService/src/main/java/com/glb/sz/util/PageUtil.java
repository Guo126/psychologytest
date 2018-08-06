package com.glb.sz.util;

import com.glb.sz.util.builder.IPageBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class PageUtil {

    public static <T> Page<T> getPage(Integer page, Integer pageSize, T example, IPageBuilder builder){
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        Example<T> objectExample = Example.of(example);
        return builder.buildPage(pageRequest,objectExample);
    }
}
