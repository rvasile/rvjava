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
public class CarteController {
  private List<Carte> carti = new ArrayList<Carte>();

  CarteController() {
    Carte f1 = new Carte(1, "Harry Potter", 12.5);
    Carte f2 = new Carte(2, "Crima din Orient Express", 9.7);
    Carte f3 = new Carte(3, "Marele Gatsby", 38.3);

    carti.add(f1);
    carti.add(f2);
    carti.add(f3);
  }

  @RequestMapping(value="/carte", method = RequestMethod.GET)
  public List<Carte> index() {
    return this.carti;
  }

  @RequestMapping(value="/carte/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Carte f : this.carti) {
      if(f.getId() == id) {
        return new ResponseEntity<Carte>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/carte/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Carte f : this.carti) {
      if(f.getId() == id) {
        this.carti.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/carte/{id}/{denumire}/{rating}", method = RequestMethod.POST)
  public ResponseEntity addCarte(@PathVariable("id") int id,
                                @PathVariable("denumire") String denumire,
                                @PathVariable("rating") double rating){
    Carte fl = new Carte(id,denumire,rating);
    carti.add(fl);


    return new ResponseEntity<Carte>(fl, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/carte/{id}", method = RequestMethod.PUT)
  public ResponseEntity putCarte(@PathVariable("id") int id){
    for(Carte f : this.carti) {
    if(f.getId() == id) {
    f.setPret(9.7);
    return new ResponseEntity<Carte>(f, new HttpHeaders(), HttpStatus.OK);
  }
}
  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}

}
