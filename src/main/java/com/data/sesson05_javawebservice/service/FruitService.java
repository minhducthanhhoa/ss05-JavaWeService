package com.data.sesson05_javawebservice.service;

import com.data.sesson05_javawebservice.dto.FruitDto;
import com.data.sesson05_javawebservice.entity.Fruit;
import com.data.sesson05_javawebservice.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FruitService {
    @Autowired
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<FruitDto> getAllFruits() {
        return fruitRepository.findAll().stream()
                .map(f -> new FruitDto(f.getId(), f.getName(), f.getPrice()))
                .collect(Collectors.toList());
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found with id " + id));
    }

    public Fruit createFruit(Fruit fruit) {
        fruit.setCreatedAt(LocalDate.now());
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Long id, Fruit fruit) {
        Fruit existing = getFruitById(id);
        existing.setName(fruit.getName());
        existing.setPrice(fruit.getPrice());
        existing.setStock(fruit.getStock());
        existing.setStatus(fruit.getStatus());
        return fruitRepository.save(existing);
    }

    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}
