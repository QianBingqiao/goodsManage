package com.qbq.domain;
/**
 * 
* @ClassName: Purchase 
* @Description: TODO(purchase表对应的封装类) 
* @author QianBingqiao 
* @date 2017年6月7日 下午4:47:02 
*
 */
public class Purchase {
	/**
	 * 采购ID
	 */
	String purId;
	/**
	 * 商品编号
	 */
	String goodsId;
	/**
	 * 进货价格
	 */
	double purPrice;
	/**
	 * 采购数量
	 */
	int purQty;
	/**
	 * 采进货日期
	 */
	String purDate;
	/**
	 * 供货商
	 */
	String supplier;
	/**
	 * 当前批次商品剩余数量
	 */
	int remainQty;
	/**
	 * 无参数构造
	 */
	public Purchase() {
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 带参数构造
	 * @param purId
	 * @param goodsId
	 * @param purPrice
	 * @param purQty
	 * @param purDate
	 * @param supplier
	 * @param remainQty
	 */
	public Purchase(String purId, String goodsId, double purPrice, int purQty, String purDate, String supplier,
			int remainQty) {
		this.purId = purId;
		this.goodsId = goodsId;
		this.purPrice = purPrice;
		this.purQty = purQty;
		this.purDate = purDate;
		this.supplier = supplier;
		this.remainQty = remainQty;
	}
	
	/**
	 * get,set方法;
	 */
	public String getPurId() {
		return purId;
	}
	public void setPurId(String purId) {
		this.purId = purId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public double getPurPrice() {
		return purPrice;
	}
	public void setPurPrice(double purPrice) {
		this.purPrice = purPrice;
	}
	public int getPurQty() {
		return purQty;
	}
	public void setPurQty(int purQty) {
		this.purQty = purQty;
	}
	public String getPurDate() {
		return purDate;
	}
	public void setPurDate(String purDate) {
		this.purDate = purDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getRemainQty() {
		return remainQty;
	}
	public void setRemainQty(int remainQty) {
		this.remainQty = remainQty;
	}
	/**
	 * toString 方法;
	 */
	@Override
	public String toString() {
		return "Purchase [purId=" + purId + ", goodsId=" + goodsId + ", purPrice=" + purPrice + ", purQty=" + purQty
				+ ", purDate=" + purDate + ", supplier=" + supplier + ", remainQty=" + remainQty + "]";
	}
	
	
	
	
	

}
