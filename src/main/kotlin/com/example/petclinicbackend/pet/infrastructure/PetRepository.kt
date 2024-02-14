package com.example.petclinicbackend.pet.infrastructure

import com.example.petclinicbackend.pet.domain.model.Pet
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PetRepository : MongoRepository<Pet, ObjectId>
