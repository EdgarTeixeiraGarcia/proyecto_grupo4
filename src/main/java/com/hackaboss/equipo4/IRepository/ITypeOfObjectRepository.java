package com.hackaboss.equipo4.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaboss.equipo4.Entities.TypeOfItem;

@Repository
public interface ITypeOfObjectRepository extends JpaRepository<TypeOfItem, Long> {
}
