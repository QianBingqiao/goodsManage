package com.qbq.domain;
/**
 * 
* @ClassName: SaleAndPur 
* @Description: TODO(saleAndPur表的封装类) 
* @author QianBingqiao 
* @date 2017年6月8日 上午10:28:27 
*
 */
public class SaleAndPur {
	/**
	 * 销售ID
	 */
	String saleId;
	/**
	 *采购ID
	 */
	String purId;
	/**
	 *商品编号
	 */
	String goodsId;
	/**
	 *采购价格
	 */
	double purPrice;
	/**
	 *销售价格
	 */
	double salePrice;
	/**
	 *当前已经 销售数量
	 */
	int currentQty;
	/**
	 * 无参数构造;
	 */
	public SaleAndPur() {

	}
	/**
	 * 带参数构造;
	 * @param saleId
	 * @param purId
	 * @param goodsId
	 * @param purPrice
	 * @param salePrice
	 * @param currentQty
	 */
	public SaleAndPur(String saleId, String purId, String goodsId, double purPrice, double salePrice, int currentQty) {
	
		this.saleId = saleId;
		this.purId = purId;
		this.goodsId = goodsId;
		this.purPrice = purPrice;
		this.salePrice = salePrice;
		this.currentQty = currentQty;
	}
	/**
	 * 
	 * get,set方法;
	 */
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
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
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getCurrentQty() {
		return currentQty;
	}
	public void setCurrentQty(int currentQty) {
		this.currentQty = currentQty;
	}
	/**
	 * toString 方法;
	 */
	@Override
	public String toString() {
		return "SaleAndPur [saleId=" + saleId + ", purId=" + purId + ", goodsId=" + goodsId + ", purPrice=" + purPrice
				+ ", salePrice=" + salePrice + ", currentQty=" + currentQty + "]";
	}
	
	
	
	
	
}
