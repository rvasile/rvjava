package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;



@RestController
public class FilmController {
  private List<Film> filme = new ArrayList<Film>();

  FilmController() {
    Film f1 = new Film(1, "Legend", 9.4);
    Film f2 = new Film(2, "Mission Impossible", 7.5);
    Film f3 = new Film(3, "Schindler's List", 8.3);

    filme.add(f1);
    filme.add(f2);
    filme.add(f3);
  }

  @RequestMapping(value="/film", method = RequestMethod.GET)
  public List<Film> index() {
    return this.filme;
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Film f : this.filme) {
      if(f.getId() == id) {
        return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Film f : this.filme) {
      if(f.getId() == id) {
        this.filme.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/film/{id}/{denumire}/{rating}", method = RequestMethod.POST)
  public ResponseEntity addFilm(@PathVariable("id") int id,
                                @PathVariable("denumire") String denumire,
                                @PathVariable("rating") double rating){
    Film fl = new Film(id,denumire,rating);
    filme.add(fl);


    return new ResponseEntity<Film>(fl, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.PUT)
  public ResponseEntity putFilm(@PathVariable("id") int id){
    for(Film f : this.filme) {
    if(f.getId() == id) {
    f.setRating(9.7);
    return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
  }
}
  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}

}
