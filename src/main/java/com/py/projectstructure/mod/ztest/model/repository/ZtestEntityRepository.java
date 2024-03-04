package com.py.projectstructure.mod.ztest.model.repository;

import com.py.projectstructure.mod.ztest.model.ZtestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZtestEntityRepository extends JpaRepository<ZtestEntity, Long> {
}
