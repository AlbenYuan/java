# Mysql 连接

## 分类

- inner join

- outer join
  
  - full outer join
  - left join
  - right join
  
## 使用
 Table: A, B
 Primary Key: id
 
 
- inner join

  结果：A ∩ B= {x | x∈A ∧ x∈B}。sql如下：
  ```mysql
  SELECT `A`.`id`,`B`.`id` FROM `A` INNER JOIN `B` ON `A`.`id` = `B`.`id`;
  ```
  
- full outer join
  
  结果： A ∪ B = { x | x∈A ∧ x∈B}
  ```mysql
  SELECT * FROM `A` FULL OUTER JOIN `B` ON `A`.`id` = `B`.`id`;
  ```
     
 