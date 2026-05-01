package org.seminify.application.quote;

import java.util.List;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class QuoteController {

  private static final Quote QUOTE = new Quote("None");
  private static final Random RANDOM = new Random();
  private final QuoteRepository quoteRepository;

  public QuoteController(QuoteRepository quoteRepository) {
    this.quoteRepository = quoteRepository;
  }

  @GetMapping
  public List<QuoteResource> quoteResources() {
    return quoteRepository
      .findAll()
      .stream()
      .map(quote -> new QuoteResource("success", quote))
      .toList();
  }

  @GetMapping("{id}")
  public QuoteResource quoteResource(@PathVariable("id") Long id) {
    return quoteRepository
      .findById(id)
      .map(quote -> new QuoteResource("success", quote))
      .orElse(new QuoteResource("Quote " + id + " does not exist", QUOTE));
  }

  @GetMapping("random")
  public QuoteResource quoteResource() {
    return quoteResource(
      (long) (RANDOM.nextDouble() * (quoteRepository.count()) + 1)
    );
  }
}
