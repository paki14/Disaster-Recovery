package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.Site;
import com.tekbasic.repo.SiteRepo;

import lombok.AllArgsConstructor;

@Service
public interface SiteService {

	public Site addSite(Site site);
	public List<Site> getallSite();
	public void updateSite(Site site,int id);
	public void deleteSite(int id);
	public Optional<Site>getSiteByID(int id);
}
