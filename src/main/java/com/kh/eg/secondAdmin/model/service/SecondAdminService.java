package com.kh.eg.secondAdmin.model.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

public interface SecondAdminService {

	Member loginAdmin(SecondAdmin sa);

	ArrayList<SecondAdmin> categoryName();

	ArrayList<SecondAdmin> searchCategory(HashMap<String, String> hmap);

	ArrayList<SecondAdmin> categoryWeeks();

	ArrayList<SecondAdmin> categoryMonth();

	ArrayList<SecondAdmin> categoryYear();

	ArrayList<SecondAdmin> categoryPriceDays();

	ArrayList<SecondAdmin> categoryPriceWeek();

	ArrayList<SecondAdmin> categoryPriceMonth();

	ArrayList<SecondAdmin> categoryPriceYear();

}
