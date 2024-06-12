package com.example.jobsearch.repository;

import com.example.jobsearch.model.Client;
import org.springframework.stereotype.Repository;

import java.util.*;
/**
 * A ClientRepository implementációja, amely memóriabeli tárhelyet használ.
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private Map<String, Client> clients = new HashMap<>();


    public ClientRepositoryImpl() {
        clients.put("client1@example.com", new Client("Client1","client1@example.com"));
        clients.put("client2@example.com", new Client("Client2","client2@example.com"));
    }
    /**
     * Egy kliens mentése a tárhelybe.
     *
     * @param client a menteni kívánt kliens
     */
    @Override
    public void save(Client client) {
        clients.put(client.getEmail(), client);
    }
    /**
     * Egy kliens keresése email cím alapján.
     *
     * @param email amely alapján keresni fogjuk a klienst
     * @return a megtalált kliens, ha létezik
     */
    @Override
    public Optional<Client> findByEmail(String email) {
        return Optional.ofNullable(clients.get(email));
    }

    /**
     * Az összes kliens lekérése a tárhelyből.
     *
     * @return a kliensek listája
     */
    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }

    /**
     * Ellenőrzi, hogy létezik-e kliens a megadott API kulccsal.
     *
     * @param apiKey az API kulcs, amely alapján keresni kívánjuk a klienst
     * @return igaz, ha létezik kliens a megadott API kulccsal, különben hamis
     */
    @Override
    public boolean existsByApiKey(String apiKey) {
        for (Client client : clients.values()) {
            if (client.getApiKey().equals(apiKey)) {
                return true;
            }
        }
        return false;
    }
}
