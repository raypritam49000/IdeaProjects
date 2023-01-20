package com.hfj.bookmarker.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfj.bookmarker.exception.ResourceNotFoundException;
import com.hfj.bookmarker.model.Bookmarker;
import com.hfj.bookmarker.repository.BookmarkerRepository;

/**
 * @author HFJ
 *
 */
@RestController
@RequestMapping("/api")
public class BookmarkerController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	BookmarkerRepository bookmarkerRepository;

	@GetMapping("/bookmarkers")
	@Cacheable(value = "bookmarker")
	public List<Bookmarker> getAllBookmarkers() {
		return bookmarkerRepository.findAll();
	}

	@PostMapping("/bookmarker")
	public Bookmarker createBookmarker(@Valid @RequestBody Bookmarker bookmarker) {
		return bookmarkerRepository.save(bookmarker);
	}

	@Cacheable(value = "bookmarker", key = "#bookmarkerId")
	@GetMapping("/bookmarker/{id}")
	public Bookmarker getBookmarkerById(@PathVariable(value = "id") Long bookmarkerId) {

		LOG.info("Getting Bookmarker with ID {}.", bookmarkerId);

		return bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));
	}

	@CachePut(value = "bookmarker", key = "#bookmarkerId")
	@PutMapping("/bookmarkers/{id}")
	public Bookmarker updateBookmarker(@PathVariable(value = "id") Long bookmarkerId,
			@Valid @RequestBody Bookmarker bookmarkerDetails) {

		Bookmarker bookmarker = bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));

		bookmarker.setTitle(bookmarkerDetails.getTitle());
		bookmarker.setContent(bookmarkerDetails.getContent());

		Bookmarker updatedBookmarker = bookmarkerRepository.save(bookmarker);
		return updatedBookmarker;
	}

	@CacheEvict(value = "bookmarker", key = "#bookmarkerId")
	@DeleteMapping("/bookmarkers/{id}")
	public String deleteBookmarker(@PathVariable(value = "id") Long bookmarkerId) {
		Bookmarker bookmarker = bookmarkerRepository.findById(bookmarkerId)
				.orElseThrow(() -> new ResourceNotFoundException("bookmarker", "id", bookmarkerId));
		LOG.info("delete Bookmarker with ID {}.", bookmarkerId);
		bookmarkerRepository.delete(bookmarker);
		return "bookmarker has deleted";
	}
}
