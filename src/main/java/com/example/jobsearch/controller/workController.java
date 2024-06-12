package com.example.jobsearch.controller;

import com.example.jobsearch.model.Client;
import com.example.jobsearch.model.Position;
import com.example.jobsearch.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Controller osztály, amely kezeli a beérkezett kérésket végpontokat, a kliensek és munkák számára.
 */
@RestController
public class workController {

    private final JobServiceImpl clientServiceImpl;

    /***
     *
     * @param clientService
     */
    @Autowired
    public workController(JobServiceImpl clientService) {
        this.clientServiceImpl = clientService;
    }

    /***
     * Egy új kliens regisztációjának megvalósítása, illetve responseban egy api kulcs visszaadva.
     * @param client az oldal törzsében beadott kliens objektum.
     * @return egy api kulcsot ha a regisztráció sikeres, illetve egy hibaüzenet ha sikertelen
     */
    @PostMapping("/client")
    public ResponseEntity<String> registerClient(@RequestBody Client client) {
        String result = clientServiceImpl.register(client);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body("E-mail cím már használatban van");
        }
    }

    /***
     * Visszaadja az összes regisztrált klienst
     *
     * @return A kliensek listája
     */
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientServiceImpl.getClients();
    }

    /***
     * Egy új pozíciót hoz létre.
     *
     * @param position Az oldalon adott Position objektumot menti el az adatbázisba.
     * @return Egy url-t tartalmazó RepsonseEntity ha sikeres volt, ellenkező esetben pedig egy hibaüzenet.
     */
    @PostMapping("/position")
    public ResponseEntity<String> createPosition(@RequestBody Position position){

        String result = clientServiceImpl.createPosition(position);
        if (result != null) {
            String url = "/position/" + result;
            RequestEntity.put(url);
            return ResponseEntity.ok(url);
        } else {
            return ResponseEntity.badRequest().body("Az állás létrehozása nem sikerült");
        }
    }

    /***
     * Megkeres egy állást a kulcsszón, illetve a földrajzi hely alapján.
     *
     * @param keyword A kulcsszó amit az oldalról kérünk le.
     * @param location A hely amit az oldalról kérünk le.
     * @return egy listát ami passzol a keresett helyre vagy megnevezésre
     */
    @GetMapping("/position/search")
    public ResponseEntity<List<Position>> searchPositions(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String location
    ){
        List<Position> positions = clientServiceImpl.searchPositions(keyword == null ? "" : keyword, location == null ? "" : location);
        return ResponseEntity.ok(positions);
    }
    /**
     * Egy listát ad vissza az összes állásról tájékoztató jelleggel.
     *
     * @return egy lista a pozíciókról.
     */
    @GetMapping("/positions")
    public List<Position> getPositions() {
        return clientServiceImpl.getPositions();
    }

    /***
     * Visszaad egy pozíciót az id alapján.
     * @param id A munka Id-ja amit vissza szeretnénk kapni
     * @return A pozíció a megadott id-val vagy null ha nincs ilyen.
     */
    @GetMapping("/position/{id}")
    public Position getPosition(@PathVariable String id) {
        return clientServiceImpl.getPositions().get(Integer.parseInt(id));
    }
}