/**
 * ItemRepository.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.spring4item.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring4item.model.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 * Itemエンティティのためのリポジトリインターフェースを定義
 * データベース操作を簡素化するSpring Data JPAを使用
 */
@Repository
public interface CustRepository extends CrudRepository<Customer, Long>{

}
