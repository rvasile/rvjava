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
public class TabletaController {
  private List<Tableta> tablete = new ArrayList<Tableta>();

  TabletaController() {
    Tableta t1 = new Tableta(1, "Apple","New Ipad Air");
    Tableta t2 = new Tableta(2, "Samsung","Galaxy Tab 3");
    Tableta t3 = new Tableta(3, "Lenovo","Idea Pad 2");

    tablete.add(t1);
    tablete.add(t2);
    tablete.add(t3);
  }

  @RequestMapping(value="/tableta", method = RequestMethod.GET)
  public List<Tableta> index() {
    return this.tablete;
  }

  @RequestMapping(value="/tableta/{id_tableta}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id_tableta") int id_tableta) {
    for(Tableta t : this.tablete) {
      if(t.getIdTableta() == id_tableta) {
        return new ResponseEntity<Tableta>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/tableta/{id_tableta}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id_tableta") int id_tableta) {
    for(Tableta t : this.tablete) {
      if(t.getIdTableta() == id_tableta) {
        this.tablete.remove(t);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/tableta", method = RequestMethod.POST)
  public void addPersoana(Tableta t){
    tablete.add(t);
  }

  @RequestMapping(value="/tableta/{id_tableta}", method = RequestMethod.PUT)
  public void putTableta(@PathVariable("id_tableta") int id_tableta, Tableta t){
    t.setIdTableta(id_tableta);
  }
}
