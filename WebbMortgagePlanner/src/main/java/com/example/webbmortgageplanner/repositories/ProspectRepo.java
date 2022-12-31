package com.example.webbmortgageplanner.repositories;

import com.example.webbmortgageplanner.models.Prospect;
import org.springframework.data.repository.CrudRepository;

public interface ProspectRepo extends CrudRepository<Prospect, Long> {
}
