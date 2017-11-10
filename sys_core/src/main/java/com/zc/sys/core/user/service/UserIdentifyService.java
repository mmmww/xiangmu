package com.zc.sys.core.user.service;
import com.zc.sys.core.user.model.UserIdentifyModel;
import com.zc.sys.common.form.Result;
/**
 * 用户认证
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月09日
 */
public interface UserIdentifyService{

	/**
 	 * 列表
 	 * @param model
 	 * @return
 	 */
	public Result list(UserIdentifyModel model);

	/**
 	 * 添加
 	 * @param model
 	 * @return
 	 */
	public Result add(UserIdentifyModel model);

	/**
 	 * 修改
 	 * @param model
 	 * @return
 	 */
	public Result update(UserIdentifyModel model);

	/**
 	 * 获取
 	 * @param model
 	 * @return
 	 */
	public Result getById(UserIdentifyModel model);

}