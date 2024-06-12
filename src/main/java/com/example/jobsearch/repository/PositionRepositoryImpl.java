package com.example.jobsearch.repository;

import com.example.jobsearch.model.Position;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * A PositionRepository implementációja, amely egy memória tárhelyet használ.
 */
@Repository
public class PositionRepositoryImpl implements PositionRepository {

    private Map<String, Position> positions = new HashMap<>();

    public PositionRepositoryImpl() {
        positions.put("1", new Position("Software Engineer", "San Francisco"));
        positions.put("2", new Position("Data Scientist", "New York"));
    }
    /**
     * Egy pozíció mentése a tárhelybe.
     *
     * @param position a menteni kívánt pozíció
     */
    @Override
    public void save(Position position) {
        positions.put(position.getTitle(), position);
    }
    /**
     * Egy pozíció keresése id alapján.
     *
     * @param id az azonosító, amely alapján keresni kívánjuk a pozíciót
     * @return a megtalált pozíció, ha létezik
     */
    @Override
    public Optional<Position> findByid(String id) {
        return Optional.ofNullable(positions.get(id));
    }
    /**
     * Az összes pozíció kilistázása.
     *
     * @return a pozíciók listája
     */
    @Override
    public List<Position> findAll() {
        return new ArrayList<>(positions.values());
    }
    /**
     * Pozíciók keresése kulcsszó és helyszín alapján.
     *
     * @param keyword a keresett kulcsszó
     * @param location a keresett helyszín
     * @return a keresési feltételeknek megfelelő pozíciók listája
     */
    @Override
    public List<Position> search(String keyword, String location) {
        List<Position> result = new ArrayList<>();
        for (Position position : positions.values()) {
            boolean matchesKeyword = keyword.isEmpty() || position.getTitle().toLowerCase().contains(keyword.toLowerCase());
            boolean matchesLocation = location.isEmpty() || position.getLocation().toLowerCase().contains(location.toLowerCase());
            if (matchesKeyword && matchesLocation) {
                result.add(position);
            }
        }
        return result;
    }
}
