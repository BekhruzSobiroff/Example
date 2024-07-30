package com.example.demo.repo;

import com.example.demo.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {

    @Query(value = "select e from Example e",nativeQuery = true)
    List<Example> findAllExample();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO example (title, solution_icon, acceptance, difficulty, frequency) VALUES (:title, :solutionIcon, :acceptance, :difficulty, :frequency)",nativeQuery = true)
    void saveAllExample(
            @Param("title") String title,
            @Param("solutionIcon") String solutionIcon,
            @Param("acceptance") Double acceptance,
            @Param("difficulty") String difficulty,
            @Param("frequency") Boolean frequency
    );
}
