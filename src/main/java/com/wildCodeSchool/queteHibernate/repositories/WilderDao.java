package com.wildCodeSchool.queteHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildCodeSchool.queteHibernate.entities.Wilder;

@Repository
public interface WilderDao extends JpaRepository<Wilder, Long> {
}
