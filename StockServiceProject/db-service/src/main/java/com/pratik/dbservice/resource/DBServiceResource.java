package com.pratik.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.dbservice.models.Quote;
import com.pratik.dbservice.models.Quotes;
import com.pratik.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
	
	private QuotesRepository quotesRepository;
	
	public DBServiceResource(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String userName){
		return getQuotesByUserName(userName);
	}
	
	private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }
	
	@PostMapping("/add")
	public List<String> addQuotes(@RequestBody final Quotes quotes) {
		quotes.getQuotes().stream()
				.map(quote -> new Quote(quotes.getUserName(), quote))
				.forEach(quote -> quotesRepository.save(quote));
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@DeleteMapping("/delete/{username}")
//	@PostMapping("/delete/{username}")
	@ResponseBody
	public boolean delete(@PathVariable("username") final String userName){
		List<Quote> quotes = quotesRepository.findByUserName(userName);
		quotesRepository.delete(quotes);
		return getQuotesByUserName(userName).isEmpty();
	}
}
