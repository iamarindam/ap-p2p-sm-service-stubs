package com.stubs.app.model.mcsend;

public class Payments {
	private int itemCount;
	private String resourceType;
	private PaymentsData data;
	
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public PaymentsData getData() {
		return data;
	}
	public void setData(PaymentsData data) {
		this.data = data;
	}
}
