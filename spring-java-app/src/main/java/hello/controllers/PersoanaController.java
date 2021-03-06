package hello.controllers;


import hello.models.Persoana;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersoanaController {
    private List<Persoana> persoane = new ArrayList<Persoana>();

    PersoanaController() {
        Persoana p1 = new Persoana(1, "John");
        Persoana p2 = new Persoana(2, "Paul");
        Persoana p3 = new Persoana(3, "Paul");

        persoane.add(p1);
        persoane.add(p2);
        persoane.add(p3);
    }

    @RequestMapping(value = "/persoana", method = RequestMethod.GET)
    public List<Persoana> index() {
        return this.persoane;
    }

    @RequestMapping(value = "/persoana/{id}", method = RequestMethod.GET)
    public ResponseEntity show(@PathVariable("id") int id) {
        for (Persoana p : this.persoane) {
            if (p.getId() == id) {
                return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/persoana/{id}", method = RequestMethod.DELETE, consumes="text/plain")
    public ResponseEntity remove(@PathVariable("id") int id) {
        for (Persoana p : this.persoane) {
            if (p.getId() == id) {
                this.persoane.remove(p);
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/persoana", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Persoana p) {

//        Persoana newPerson = new Persoana(id,name);
        persoane.add(p);
        String numePersoana = p.getName();
        for(Persoana p_tmp : this.persoane) {
            if(p_tmp.getName().equals(numePersoana)) {
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/persoana", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Persoana p) {


        int idPersoana = p.getId();
        for(Persoana p_tmp : this.persoane) {
            if(p_tmp.getId()==(idPersoana)) {
                p_tmp.setId(p.getId());
                p_tmp.setName(p.getName());
                return new ResponseEntity<ArrayList<Persoana>>((ArrayList<Persoana>) persoane, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }



}
