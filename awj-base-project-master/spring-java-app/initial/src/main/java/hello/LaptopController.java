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
public class LaptopController {
  private List<Laptop> laptopuri = new ArrayList<Laptop>();

  LaptopController() {
    Laptop l1 = new Laptop(1, "HP Pavilion 3000","Intel i3");
    Laptop l2 = new Laptop(2, "Dell Latitude 3042","Intel i5");
    Laptop l3 = new Laptop(3, "Toshiba Satellite 6500","Intel i7");

    laptopuri.add(l1);
    laptopuri.add(l2);
    laptopuri.add(l3);
  }

  @RequestMapping(value="/laptop", method = RequestMethod.GET)
  public List<Laptop> index() {
    return this.laptopuri;
  }

  @RequestMapping(value="/Laptop/{id_laptop}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id_laptop") int id_laptop) {
    for(Laptop l : this.laptopuri) {
      if(l.getIdLaptop() == id_laptop) {
        return new ResponseEntity<Laptop>(l, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/laptop/{id_laptop}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id_laptop") int id_laptop) {
    for(Laptop l : this.laptopuri) {
      if(l.getIdLaptop() == id_laptop) {
        this.laptopuri.remove(l);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/laptop/{id_laptop}/{denumire}/{procesor}", method = RequestMethod.POST)
  public ResponseEntity addLaptop(@PathVariable ("id_laptop") int id_laptop,
                                  @PathVariable ("denumire") String denumire,
                                  @PathVariable ("procesor") String procesor){

    Laptop l1 = new Laptop(id_laptop,denumire,procesor);
    laptopuri.add(l1);
    return new ResponseEntity<Laptop>(l1, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/laptop/{id_laptop}", method = RequestMethod.PUT)
  public ResponseEntity putLaptop(@PathVariable("id_laptop") int id_laptop){
    for(Laptop l: this.laptopuri){
      if(l.getIdLaptop()==id_laptop){
        l.setProcesor("Intel i3");
        return new ResponseEntity<Laptop>(l,new HttpHeaders(),HttpStatus.OK);
      }

    }
    return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
  }

}
