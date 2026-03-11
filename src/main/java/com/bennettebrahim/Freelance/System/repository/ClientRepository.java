package com.bennettebrahim.Freelance.System.repository;

import com.bennettebrahim.Freelance.System.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
