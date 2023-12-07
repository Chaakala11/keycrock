package com.cnss.back.Repository;

import com.cnss.back.Entity.Authority;
import com.cnss.back.Entity.Office;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "offices", path = "offices")
public interface OfficeRepository extends PagingAndSortingRepository<Office,Long> {
}
