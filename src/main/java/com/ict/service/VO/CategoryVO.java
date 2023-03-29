package com.ict.service.VO;

import java.util.List;

public class CategoryVO {
	List<String> Category;
	String c_kind,c_img;
	int c_idx;
	public String getC_kind() {
		return c_kind;
	}
	public void setC_kind(String c_kind) {
		this.c_kind = c_kind;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public List<String> getCategory() {
		return Category;
	}
	public void setCategory(List<String> category) {
		Category = category;
	}



}
