package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.Site;
import com.tekbasic.repo.SiteRepo;
@Service
public class SiteServiceIMPL implements SiteService{

	@Autowired
	private SiteRepo siteRepo;
	@Override
	public Site addSite(Site site) {
		return siteRepo.save(site);
	}

	@Override
	public List<Site> getallSite() {
		return siteRepo.findAll();
	}

	@Override
	public void updateSite(Site site,int id) {
		siteRepo.updateSite(site.getSiteCode(),id);
	}

	@Override
	public void deleteSite(int id) {
		siteRepo.deleteById(id);
	}

	@Override
	public Optional<Site> getSiteByID(int id) {
		return siteRepo.findById(id);
	}

}
