package com.ueh.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageInfo implements Serializable {
  
	private static final long serialVersionUID = 5151521061950048117L;

	public PageInfo(int totalCount,int currPageNum,int pageSize)
	{
		 
			this.totalCount=totalCount;
			this.currPageNum=currPageNum;
			this.pageSize=pageSize;
			
			this.totalPageCount=totalCount/pageSize;
			if(totalCount%pageSize!=0)
			{
				this.totalPageCount++;
			} 
			
			if(currPageNum>1)
			{
				prePageNum=currPageNum-1;
			}
			else
			{
				prePageNum=1;
			}
			
			if(currPageNum>=this.totalPageCount)
			{
				this.nextPageNum=-1;
				this.currPageNum=this.totalPageCount;
			}
			else
			{
				this.nextPageNum=currPageNum+1;
			}  
	}
	
	

	private int currPageNum=1;
	
	private int pageSize=10;
	
	private int totalCount=0;
	
	private int totalPageCount=1;
	
	private int nextPageNum=1;
	
	private int prePageNum=1;
	
	private List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

	public int getCurrPageNum() {
		return currPageNum;
	}

	public void setCurrPageNum(int currPageNum) {
		this.currPageNum = currPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	} 
	
}
