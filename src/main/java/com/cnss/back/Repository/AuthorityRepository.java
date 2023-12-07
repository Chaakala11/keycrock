package com.cnss.back.Repository;

import com.cnss.back.Entity.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authorities", path = "authorities")
public interface AuthorityRepository extends PagingAndSortingRepository<Authority,Long> {
    Authority findByRole(String role);
}
