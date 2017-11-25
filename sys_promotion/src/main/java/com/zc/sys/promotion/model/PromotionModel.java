package com.zc.sys.promotion.model;
import org.springframework.beans.BeanUtils;

import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.common.constant.BaseConstant;
import com.zc.sys.promotion.entity.Promotion;
/**
 * 活动推广
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public class PromotionModel extends Promotion {
	/** 序列号 **/
	private static final long serialVersionUID = 1L;

	/** 当前页码 **/
	private int pageNo;
	/** 每页数据条数 **/
	private int pageSize = Page.ROWS;
	/** 条件查询 **/
	private String searchName;

	/**
	 * 实体转换model
	 */
	public static PromotionModel instance(Promotion promotion) {
		PromotionModel promotionModel = new PromotionModel();
		BeanUtils.copyProperties(promotion, promotionModel);
		return promotionModel;
	}

	/**
	 * model转换实体
	 */
	public Promotion prototype() {
		Promotion promotion = new Promotion();
		BeanUtils.copyProperties(this, promotion);
		return promotion;
	}

	/**
	 * 校验参数
	 */
	public void validAdd() {
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("标题不能为空！");
		}
		if(this.getWay() <= 0){
			throw new BusinessException("参数错误！");
		}
		if (StringUtil.isBlank(this.getContent())) {
			throw new BusinessException("内容不能为空！");
		}
		if(this.getStartTime() == null){
			throw new BusinessException("开始时间不能为空！");
		}
		if(this.getEndTime() == null){
			throw new BusinessException("结束时间不能为空！");
		}
	}

	/**
	 * 初始化添加
	 */
	public void initAdd() {
		if(this.getState() == 0){
			this.setState(BaseConstant.INFO_STATE_NO);
		}
		this.setAddTime(DateUtil.getNow());
	}

	/** 获取【当前页码】 **/
	public int getPageNo() {
		return pageNo;
	}

	/** 设置【当前页码】 **/
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/** 获取【每页数据条数】 **/
	public int getPageSize() {
		return pageSize;
	}

	/** 设置【每页数据条数】 **/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取【条件查询】 **/
	public String getSearchName() {
		return searchName;
	}

	/** 设置【条件查询】 **/
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

}