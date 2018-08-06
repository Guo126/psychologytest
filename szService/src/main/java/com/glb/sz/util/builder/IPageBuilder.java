package com.glb.sz.util.builder;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IPageBuilder<T> {
     Page<T> buildPage(PageRequest pageRequest, Example<T> example);
}
