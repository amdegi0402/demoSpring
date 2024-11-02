/**
 * Customer.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.spring4item.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
@Entity
@Table
(name = "m_item")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	private String custName;
	private String custCategory;
	/**
	 * @param custName
	 * @param custCategory
	 */
	public Customer(String custName, String custCategory) {
		super();
		this.custName = custName;
		this.custCategory = custCategory;
	}
	/**
	 * custIdのGetter
	 * @return custId
	 */
	public Long getCustId() {
		return custId;
	}
	/**
	 * custIdのSetter
	 * @param custId
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	/**
	 * custNameのGetter
	 * @return custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * custNameのSetter
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * custCategoryのGetter
	 * @return custCategory
	 */
	public String getCustCategory() {
		return custCategory;
	}
	/**
	 * custCategoryのSetter
	 * @param custCategory
	 */
	public void setCustCategory(String custCategory) {
		this.custCategory = custCategory;
	}


}
