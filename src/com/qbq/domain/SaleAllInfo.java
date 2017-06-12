package com.qbq.domain;
/**
 * 
* @ClassName: SaleAllInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author QianBingqiao 
* @date 2017年6月11日 下午1:56:41 
*
 */
public class SaleAllInfo {
	// 商品编号，
	String goodsId;
	// 商品名称，
	String goodsName;
	// 商品销售总量，
	int saleCount;
	// 商品采购总量，
	int purCount;
	// 商品剩余库存，
	int goodsCount;
	// 商品盈利总额
	double gain;
	/**
	 * 
	 */
	public SaleAllInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaleAllInfo(String goodsId, String goodsName, int saleCount, int purCount, int goodsCount, double gain) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.saleCount = saleCount;
		this.purCount = purCount;
		this.goodsCount = goodsCount;
		this.gain = gain;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getPurCount() {
		return purCount;
	}
	public void setPurCount(int purCount) {
		this.purCount = purCount;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public double getGain() {
		return gain;
	}
	public void setGain(double gain) {
		this.gain = gain;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gain);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + goodsCount;
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + purCount;
		result = prime * result + saleCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleAllInfo other = (SaleAllInfo) obj;
		if (Double.doubleToLongBits(gain) != Double.doubleToLongBits(other.gain))
			return false;
		if (goodsCount != other.goodsCount)
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (purCount != other.purCount)
			return false;
		if (saleCount != other.saleCount)
			return false;
		return true;
	}
	
	
	

}
