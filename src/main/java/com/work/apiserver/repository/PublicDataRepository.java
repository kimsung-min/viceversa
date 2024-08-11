package com.work.apiserver.repository;

import com.work.apiserver.model.PublicData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicDataRepository extends JpaRepository<PublicData, Long> {
}
