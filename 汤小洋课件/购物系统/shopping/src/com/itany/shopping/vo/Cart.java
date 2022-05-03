package com.itany.shopping.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itany.shopping.entity.Item;
import com.itany.shopping.entity.Product;
import com.itany.shopping.exception.ProductNotFoundException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ProductService;

/**
 * 购物车
 */
public class Cart {
	private List<Item> items = new ArrayList<Item>();
	
	private ProductService productService=(ProductService) ObjectFactory.getObject("productServiceProxy");

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * 添加商品到购物车
	 * @param id 要添加的商品的id
	 * @throws ProductNotFoundException 
	 */
	public void add(int id) throws ProductNotFoundException{
		Product product = productService.findById(id);
		
		// 判断是否存在该商品
		if(product==null){
			throw new ProductNotFoundException("商品不存在");
		}
		
		// 判断是否购买过此商品
		for (Item item : items) {
			if(item.getProduct().getId()==id){
				item.setNum(item.getNum()+1); // 修改数量
				item.setPrice(item.getProduct().getPrice()*item.getNum()); // 修改明细价格
				return;
			}
		}
		
		// 如果从未购买过该商品，创建一个新的明细
		Item item = new Item();
		item.setProduct(product);
		item.setNum(1);
		item.setPrice(product.getPrice());
		items.add(item);
	}
	
	/**
	 * 
	 * 从购物车中删除商品
	 * @param 要删除的商品的id
	 */
	public void removeById(int id) {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(item.getProduct().getId()==id){
				items.remove(item);
				break;
			}
		}
	}

	/**
	 * 
	 * 根据id修改指定商品的数量
	 * @param id  要修改的商品的id
	 * @param num  数量
	 */
	public void modifyNum(int id, int num) {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(item.getProduct().getId()==id){
				item.setNum(num); // 修改数量
				item.setPrice(item.getProduct().getPrice()*item.getNum()); // 修改明细价格
			}
		}
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		items.clear();
	}

}
