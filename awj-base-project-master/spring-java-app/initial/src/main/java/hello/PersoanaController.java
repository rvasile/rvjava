package hello;

import hello.models.*;
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
import java.lang.*;


@RestController
public class PersoanaController {
  private List<Persoana> persoane = new ArrayList<Persoana>();

  PersoanaController() {
    Persoana p1 = new Persoana(1, "Alex","Ploiesti");
    Persoana p2 = new Persoana(2, "Razvan","Targoviste");
    Persoana p3 = new Persoana(3, "Robert","Slatina");

    persoane.add(p1);
    persoane.add(p2);
    persoane.add(p3);
  }


  @RequestMapping(value="/persoana", method = RequestMethod.GET)
  public List<Persoana> index() {
    return this.persoane;
  }

  @RequestMapping(value="/persoana/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Persoana p : this.persoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/persoana/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") long id) {
    for(Persoana p : this.persoane) {
      if(p.getId() == id) {
        this.persoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/persoana/{id}/{nume}/{localitate}", method = RequestMethod.POST)
  public ResponseEntity addPersoana(@PathVariable ("id") int id,
                                    @PathVariable ("nume") String nume,
                                    @PathVariable ("localitate") String localitate){

    Persoana p1=new Persoana (id,nume,localitate);
    persoane.add(p1);
    return new ResponseEntity<Persoana>(p1,new HttpHeaders(),HttpStatus.OK);
  }

  @RequestMapping(value="/persoana/{id}", method = RequestMethod.PUT)
  public ResponseEntity putPersoana(@PathVariable("id") int id){
    for(Persoana p: this.persoane){
      if(p.getId()==id){
        p.setLocalitate("Bucuresti");

        return new ResponseEntity <Persoana> (p,new HttpHeaders(),HttpStatus.OK);
      }

    }
      return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
  }
}
