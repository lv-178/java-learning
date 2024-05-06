package com.example.springexample.services;

import com.example.springexample.dto.NewsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.TreeMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDto> {

    private final TreeMap<Integer, NewsDto> storage = new TreeMap<>();

    @Override
    public ResponseEntity getById(Integer id) {
        System.out.println("get by id: " + id);
        if (storage.get(id) == null) {
            return new ResponseEntity("{\n\t\"message\": \"Новость с ID " + id + " не найдена.\"\n}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(storage.get(id).toString(), HttpStatus.OK);
    }

    @Override
    public Collection<NewsDto> getAll() {
        System.out.println("get all");
        return storage.values();
    }

    @Override
    public ResponseEntity create(NewsDto item) {
        System.out.println("create");
        int nextId = storage.isEmpty() ? 0 : storage.lastKey() + 1;
        item.setId(nextId);
        storage.put(nextId, item);
        storage.get(nextId).setDate(LocalDateTime.now(ZoneId.of("Europe/Moscow")).toString());
        return new ResponseEntity(storage.get(nextId).toString(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(Integer id, NewsDto item) {
        System.out.println("update " + id);
        if (!storage.containsKey(id)) {
            System.out.println("no such item, cannot update");
            return new ResponseEntity("{\n\t\"message\": \"Новость с ID " + id + " не найдена.\"\n}", HttpStatus.NOT_FOUND);
        }
        String date = storage.get(id).getDate();
        item.setId(id);
        storage.put(id, item);
        storage.get(id).setDate(date);
        return new ResponseEntity(storage.get(id).toString(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Integer id) {
        System.out.println("delete " + id);
        if (storage.get(id) == null) {
            return new ResponseEntity("{\n\t\"message\": \"Новость с ID " + id + " не найдена.\"\n}", HttpStatus.NOT_FOUND);
        }
        storage.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
