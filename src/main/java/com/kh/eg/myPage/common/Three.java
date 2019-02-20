package com.kh.eg.myPage.common;

import java.text.DecimalFormat;

public class Three {
	
	 public static String toNumFormat(int num) {
		  DecimalFormat df = new DecimalFormat("#,###");
		  return df.format(num);
	}
}
