package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecsample.entity.Product;

@Controller
public class ProductController {

	@GetMapping("/products")
	public String showList(Model model) {
		//		// 仮のデータをべた書き
		//		String[][] products = {
		//				{ "1", "コーヒーカップ", "1200" },
		//				{ "2", "ティーポット", "2400" },
		//				{ "3", "マグカップ", "1500" }
		//		};

		List<Product> products = Arrays.asList(
				new Product(1, "コーヒーカップ", 1200),
				new Product(2, "ティーポット", 2400),
				new Product(3, "マグカップ", 1500));
		model.addAttribute("products", products);
		return "product/list";
	}

	@GetMapping("/product/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		//		String name;
		//		int price;
		//
		//		// ID によって商品を切り替える(仮のデータ）
		//		if (id == 1) {
		//			name = "コーヒーカップ";
		//			price = 1200;
		//		} else if (id == 2) {
		//			name = "ティーポット";
		//			price = 2400;
		//		} else {
		//			name = "未登録の商品";
		//			price = 0;
		//		}
		//
		//		model.addAttribute("id", id);
		//		model.addAttribute("name", name);
		//		model.addAttribute("price", price);

		Product product;
		if (id == 1) {
			product = new Product(1, "コーヒーカップ", 1200);
		} else if (id == 2) {
			product = new Product(2, "ティーポット", 2400);
		} else {
			product = new Product(0, "未登録の商品", 0);
		}
		model.addAttribute("product", product);

		//商品詳細ページを表示する
		return "product/detail";
	}
}
