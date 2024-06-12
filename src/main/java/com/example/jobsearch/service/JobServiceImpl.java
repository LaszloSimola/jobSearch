package com.example.jobsearch.service;

import com.example.jobsearch.repository.ClientRepository;
import com.example.jobsearch.repository.ClientRepositoryImpl;
import com.example.jobsearch.repository.PositionRepositoryImpl;
import com.example.jobsearch.model.Client;
import com.example.jobsearch.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * A service megvalósítása, amely az kliensekkel és pozíciókkal kapcsolatos műveleteket végzi.
 */
@Service
public class JobServiceImpl implements JobService {

    private final ClientRepositoryImpl clientRepository;
    private final PositionRepositoryImpl positionRepository;

    @Autowired
    public JobServiceImpl(ClientRepositoryImpl clientRepository, PositionRepositoryImpl positionRepository) {
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }
    /**
     * Ellenőrzi, hogy az API kulcs érvényes-e.
     *
     * @param apiKey az ellenőrizendő API kulcs
     * @return true, ha az API kulcs érvényes, egyébként false
     */
    public boolean isValidApiKey(String apiKey) {
        return clientRepository.existsByApiKey(apiKey);
    }
    /**
     * Regisztrál egy új ügyfelet.
     *
     * @param client a regisztrálandó ügyfél
     * @return az ügyfél számára generált API kulcs, vagy null, ha a regisztráció nem sikerült
     */
    @Override
    public String register(Client client) {
        if (!isValidEmail(client.getEmail())) {
            return null;
        }
        if (clientRepository.findByEmail(client.getEmail()).isPresent()) {
            return null;
        }
        String apiKey = UUID.randomUUID().toString();
        client.setApiKey(apiKey);
        clientRepository.save(client);
        return apiKey;
    }
    /**
     * Ellenőrzi, hogy az e-mail cím érvényes-e.
     *
     * @param email az ellenőrizendő e-mail cím
     * @return true, ha az e-mail cím érvényes, egyébként false
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    /**
     * Létrehoz egy új pozíciót.
     *
     * @param position a létrehozandó pozíció
     * @return a pozíció azonosítója, vagy null, ha a létrehozás nem sikerült
     */
    @Override
    public String createPosition(Position position) {
        position.setId(UUID.randomUUID().toString());
        positionRepository.save(position);
        return position.getTitle();
    }
    /**
     * Visszaadja az összes pozíciót.
     *
     * @return a pozíciók listája
     */
    @Override
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }
    /**
     * Pozíciók keresése kulcsszó és helyszín alapján.
     *
     * @param keyword a keresett kulcsszó
     * @param location a keresett helyszín
     * @return a keresési feltételeknek megfelelő pozíciók listája
     */
    @Override
    public List<Position> searchPositions(String keyword, String location) {
        return positionRepository.search(keyword, location);
    }
    /**
     * Pozíció lekérdezése azonosító alapján.
     *
     * @param id a keresett pozíció azonosítója
     * @return a megtalált pozíció, ha létezik
     */
    public Optional<Position> getPosition(String id) {
        return positionRepository.findByid(id);
    }
    /**
     * Visszaadja az összes ügyfelet.
     *
     * @return az ügyfelek listája
     */
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
