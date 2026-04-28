package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/products")
	public String showList() {
		// 商品一覧ページを表示する
		return "product/list";
	}
}
