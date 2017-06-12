package com.qbq.domain;
/**
 * 
* @ClassName: Goods 
* @Description: TODO(Goods表的封装类) 
* @author QianBingqiao 
* @date 2017年6月7日 下午4:46:50 
*
 */
public class Goods {
	/**
	 * 商品编号
	 */
	String goodsId;
	/**
	 * 商品名称
	 */
	String goddsName;
	/**
	 * 单位
	 */
	String goodsUnit;
	/**
	 * 状态
	 */
	int goodsStatus;
	/**
	 * 商品库存数量
	 */
	int goodsQty;
	/**
	 *无参数构造方法
	 */
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 带参数构造方法;
	 * @param goodsId
	 * @param goddsName
	 * @param goodsUnit
	 * @param goodsStatus
	 * @param goodsQty
	 */
	public Goods(String goodsId, String goddsName, String goodsUnit, int goodsStatus, int goodsQty) {
		super();
		this.goodsId = goodsId;
		this.goddsName = goddsName;
		this.goodsUnit = goodsUnit;
		this.goodsStatus = goodsStatus;
		this.goodsQty = goodsQty;
	}
	
	
	/**
	 * 
	 *get,set方法;
	 */
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoddsName() {
		return goddsName;
	}
	public void setGoddsName(String goddsName) {
		this.goddsName = goddsName;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public int getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(int goodsQty) {
		this.goodsQty = goodsQty;
	}
	/**
	 * toString 方法;
	 */
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goddsName=" + goddsName + ", goodsUnit=" + goodsUnit + ", goodsStatus="
				+ goodsStatus + ", goodsQty=" + goodsQty + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goddsName == null) ? 0 : goddsName.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + goodsQty;
		result = prime * result + goodsStatus;
		result = prime * result + ((goodsUnit == null) ? 0 : goodsUnit.hashCode());
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
		Goods other = (Goods) obj;
		if (goddsName == null) {
			if (other.goddsName != null)
				return false;
		} else if (!goddsName.equals(other.goddsName))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsQty != other.goodsQty)
			return false;
		if (goodsStatus != other.goodsStatus)
			return false;
		if (goodsUnit == null) {
			if (other.goodsUnit != null)
				return false;
		} else if (!goodsUnit.equals(other.goodsUnit))
			return false;
		return true;
	}
	
	

}
