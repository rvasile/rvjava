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


@RestController
public class LivrareController {
  private List<Livrare> livrari = new ArrayList<Livrare>();

  LivrareController() {
    Livrare liv1 = new Livrare(8,2200,"John Smith");
    Livrare liv2 = new Livrare(5,4500,"Carla Jager");
    Livrare liv3 = new Livrare(2,399,"Aaron Hunt");

    livrari.add(liv1);
    livrari.add(liv2);
    livrari.add(liv3);
  }

  @RequestMapping(value="/livrare", method = RequestMethod.GET)
  public List<Livrare> index() {
    return this.livrari;
  }

  @RequestMapping(value="/Livrare/{id_livrare}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id_livrare") int id_livrare) {
    for(Livrare liv : this.livrari) {
      if(liv.getIdLivrare() == id_livrare) {
        return new ResponseEntity<Livrare>(liv, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/livrare/{id_livrare}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id_livrare") int id_livrare) {
    for(Livrare liv : this.livrari) {
      if(liv.getIdLivrare() == id_livrare) {
        this.livrari.remove(liv);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/livrare/{id_livrare}/{pret}/{nume_client}", method = RequestMethod.POST)
  public ResponseEntity addLivrare(@PathVariable ("id_livrare") int id_livrare,
                                   @PathVariable ("pret") double pret,
                                   @PathVariable ("nume_client") String nume_client){
    Livrare liv1= new Livrare (id_livrare,pret,nume_client);
    livrari.add(liv1);
    return new ResponseEntity<Livrare>(liv1, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/livrare/{id_livrare}", method = RequestMethod.PUT)
  public ResponseEntity putLivrare(@PathVariable("id_livrare") int id_livrare){
    for(Livrare liv: this.livrari){
      if(liv.getIdLivrare()==id_livrare){
        liv.setNumeClient("Andrei");

        return new ResponseEntity <Livrare> (liv,new HttpHeaders(),HttpStatus.OK);
      }

    }
      return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
  }


}
