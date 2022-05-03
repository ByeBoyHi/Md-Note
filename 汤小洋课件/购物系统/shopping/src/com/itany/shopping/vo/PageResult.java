package com.itany.shopping.vo;

import java.util.List;

/**
 * 分页结果
 */
public class PageResult<T> {
	private int count; // 总数据条数
	private List<T> list; // 当前页的数据
	private int pageNo; // 当前页码
	private int pages; // 总页数

	public PageResult(int count, List<T> list, int pageNo, int pageSize) {
		this.count = count;
		this.list = list;
		this.pageNo = pageNo;
		// 计算总页数
		pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}

	public int getCount() {
		return count;
	}

	public List<T> getList() {
		return list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPages() {
		return pages;
	}

	/**
	 * 获取上一页
	 */
	public int getPrePage() {
		return pageNo > 1 ? pageNo - 1 : 1;
	}

	/**
	 * 获取下一页
	 */
	public int getNextPage() {
		return pageNo < pages ? pageNo + 1 : pages;
	}

}
