package com.monsters.generationcodingadmin.common.web;

import org.springframework.data.domain.Page;
import lombok.Data;

import java.util.List;

/**
 * 返回的分页记录
 * @author Monsters
 * @date 2022/9/9 9:06 PM
 */
@Data
public class PageData<T> {

    private long current;

    private long pageSize;

    private long total;

    private long pages;

    private List<T> data;

    public static <T> PageData convertPageData(Page<T> page){
        PageData<T> pageData = new PageData<>();
        pageData.setCurrent(page.getNumber() + 1);
        pageData.setPageSize(page.getSize());
        pageData.setTotal(page.getTotalElements());
        pageData.setPages(page.getTotalPages());
        pageData.setData(page.getContent());
        return pageData;
    }

    public static <T> PageData convertPageData(Page<?> page, List<T> data){
        PageData<T> pageData = new PageData<>();
        pageData.setCurrent(page.getNumber() + 1);
        pageData.setPageSize(page.getSize());
        pageData.setTotal(page.getTotalElements());
        pageData.setPages(page.getTotalPages());
        pageData.setData(data);
        return pageData;
    }
}
