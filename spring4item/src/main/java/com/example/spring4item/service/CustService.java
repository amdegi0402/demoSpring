/**
 * CustService.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.spring4item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.example.spring4item.model.Customer;
import com.example.spring4item.repo.CustRepository;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustService {

	@Autowired
	private CustRepository custRepository;

	// 全件検索
	@Cacheable("getAllCustomer")
	public List<Customer> getAllCustomer() {
		List<Customer> allCustomer = new ArrayList();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// データベースからデータを取得し、foreachを使ってallCustomerリストに追加していく処理
		custRepository.findAll().forEach(allCustomer::add);
		return allCustomer;
	}

	@Cacheable(value = "getCustomer", key = "#p0")
	// 1件検索 Optionalとは値が「存在するかもしれないし、しないかもしれない」状況を表現
	public Optional<Customer> getCustomer(Long custId) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return custRepository.findById(custId);
	}

	// 登録
	@CacheEvict(value = "getAllCustomer", allEntries = true)
	public void addCustomer(Customer customer) {
		custRepository.save(customer);
	}

	// 更新
	@Caching(evict = { @CacheEvict(value = "getCustomer", key = "#p0"),
			@CacheEvict(value = "getAllCustomer", allEntries = true) })
	public void updateCustomer(Long custId, Customer customer) {
		custRepository.save(customer);
	}

	// 削除
	@Caching(evict = { @CacheEvict(value = "getCustomer", key = "#p0"),
			@CacheEvict(value = "getAllCustomer", allEntries = true) })
	public void deleteCustomer(Long custId) {
		custRepository.deleteById(custId);
	}
}
