package com.qbq.domain;
/**
 * 
* @ClassName: Sale 
* @Description: TODO(sale表的封装类) 
* @author QianBingqiao 
* @date 2017年6月7日 下午4:47:09 
*
 */
public class Sale {
	/**
	 * 销售ID
	 */
    String  saleId;
	/**
	 * 商品编号
	 */
    String goodsId;
	/**
	 * 销售数量
	 */
    int saleQty;
	/**
	 * 销售价格
	 */
    double salePrice;
	/**
	 * 销售日期
	 */
    String saleDate;
    /**
     * 无参数构造
     */
	public Sale() {

	}
	
	/**
	 * 带参数构造
	 * @param saleId
	 * @param goodsId
	 * @param saleQty
	 * @param salePrice
	 * @param saleDate
	 */
	public Sale(String saleId, String goodsId, int saleQty, double salePrice, String saleDate) {
		
		this.saleId = saleId;
		this.goodsId = goodsId;
		this.saleQty = saleQty;
		this.salePrice = salePrice;
		this.saleDate = saleDate;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(int saleQty) {
		this.saleQty = saleQty;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
		/**
		 * toString 方法;
		 */
	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", goodsId=" + goodsId + ", saleQty=" + saleQty + ", salePrice=" + salePrice
				+ ", saleDate=" + saleDate + "]";
	}
	
	
    
    
    
}
