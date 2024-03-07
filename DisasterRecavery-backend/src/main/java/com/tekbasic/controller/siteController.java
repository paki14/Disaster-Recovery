package com.tekbasic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tekbasic.entity.Site;
import com.tekbasic.service.SiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/site")
@CrossOrigin("http//:localhost:4210")
public class siteController {

	@Autowired
	private SiteService siteService;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addSite(@RequestBody Site site) {
		siteService.addSite(site);
	}
	@GetMapping("/viewAll")
	public List<Site> getallSite() {
		return siteService.getallSite();
	}
	@GetMapping("getSite/{id}")
	public Optional<Site> getsiteByID(@PathVariable("id") int id) {
		return siteService.getSiteByID(id);
	}
	@PutMapping("/update/{id}")
	public void updateSite(@RequestBody Site site,@PathVariable("id")int id) {
		siteService.updateSite(site, id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteSite(@PathVariable("id")int id) {
		siteService.deleteSite(id);
	}
}
