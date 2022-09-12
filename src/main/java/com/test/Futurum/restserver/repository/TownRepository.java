package com.test.Futurum.restserver.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends CrudRepository<TownEntity, Long> {
}
