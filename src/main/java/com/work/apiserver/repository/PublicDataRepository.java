package com.work.apiserver.repository;

import com.work.apiserver.model.PublicData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PublicDataRepository extends JpaRepository<PublicData, Long>, JpaSpecificationExecutor<PublicData> {
}
