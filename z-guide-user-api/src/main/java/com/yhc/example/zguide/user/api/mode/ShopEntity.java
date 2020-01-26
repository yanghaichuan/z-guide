package com.yhc.example.zguide.user.api.mode;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author yanghaichuan
 */
@Data
public class ShopEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * 店铺名称
	 */
	private String shopName;
	
	/**
	 * 店铺URL
	 */
	private String shopLogo;
	
	/**
	 * 店铺归属user
	 */
	private Long userId;
	
	/**
	 * 姓名
	 */
	private String realName;
	
	/**
	 * 分类ID
	 */
	private Long classId;
	
	/**
	 * 分类名称
	 */
	private String className;
	
	/**
	 * 0未审核1已交审核2审核中3完成4审核未通过
	 */
	private Integer status;
	
	/**
	 * 店铺说明
	 */
	private String shopText;
	
}
