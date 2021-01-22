package com.example.samplelambda.SampleLambda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LambdaRepository extends JpaRepository<Book, Integer> {
}
