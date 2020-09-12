package com.mattleith.dddmaven.dao;

import com.mattleith.dddmaven.model.Load;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends CrudRepository<Load, Long> {
}
