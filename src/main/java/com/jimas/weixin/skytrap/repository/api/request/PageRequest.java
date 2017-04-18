package com.jimas.weixin.skytrap.repository.api.request;

import java.io.Serializable;

/**
 * @Description 分页请求参数
 * @author weqinjia.liu
 * @Date 2017年4月18日
 * @param <T>
 */
public class PageRequest<T> implements Serializable{

    private static final long serialVersionUID = -1488509172085275664L;
    private int pageNumber = 1; 	// 当前页默认为第一页
	private int limit = 10; 		// 每页显示记录数
	private int step = 0; 			// 数据库初始步长 此参数无需填写，后台负责计算
	private String orderBy;			// 按照某字段排序 如 id desc,多字段查询如 tp.id,tp.propNameZh desc
	private T params;				// 查询基础条件对象
	
	public PageRequest() {
		if(pageNumber<=1){
			pageNumber=1;
		}
	}
	public PageRequest(int pageNumber,int limit) {
		if(pageNumber<=1){
			pageNumber=1;
		}
		this.pageNumber = pageNumber;
		this.limit = limit;
	}
	//初始化数据库起始索引
	private void initStep(){
		//纠正传入错误数据，因经常总页数传入0，导致数据库计算错误
		if(limit<=0){
			limit=10;
		}
		//纠正传入错误数据
		if(pageNumber<=0){
			step=0;
		}else{
			step=(pageNumber-1)*limit;
		}
	}
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStep() {
		initStep();
		return step;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public T getParams() {
		return params;
	}
	public void setParams(T params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "PageRequest [limit=" + limit + ", pageNumber=" + pageNumber + ", step=" + step + "]";
	}

}
