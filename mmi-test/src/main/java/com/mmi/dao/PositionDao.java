package com.mmi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.mmi.model.Position;

public interface PositionDao extends PagingAndSortingRepository<Position, Integer>, QueryByExampleExecutor<Position>{

}
