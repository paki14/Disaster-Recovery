package com.tekbasic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.tekbasic.entity.Site;
@Repository
public interface SiteRepo extends JpaRepository<Site, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Site s set s.siteCode=:siteCode where id=:id")
	void updateSite(@Param("siteCode")String siteCode,@Param("id")int id);

}
