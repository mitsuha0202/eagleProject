package com.kh.eg.item.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;

public interface ItemService {

	int insertItem(HashMap<String, Object> hmap);

	ArrayList<Category> selectCategory();

}
