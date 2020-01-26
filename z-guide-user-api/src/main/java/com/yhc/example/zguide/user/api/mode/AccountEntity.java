package com.yhc.example.zguide.user.api.mode;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;


/**
 * 
 * @author yanghaichuan
 */
@Data
public class AccountEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * 现金
	 */
	private BigDecimal cash;
	
	/**
	 * 积分
	 */
	private BigDecimal integral;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 输入用户ID
	 */
	private Long inputMan;
	
	/**
	 * 输入时间
	 */
	private Date inputTime;
	
	/**
	 * 修改用户ID
	 */
	private Long updateMan;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;

	
}
