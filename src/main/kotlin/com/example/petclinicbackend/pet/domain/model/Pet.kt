package com.example.petclinicbackend.pet.domain.model

import com.example.petclinicbackend.pet.api.PetDto
import com.example.petclinicbackend.pet.domain.model.value.Breed
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("pets")
data class Pet(
    @Id
    val id: ObjectId = ObjectId(),
    val name: String,
    val breed: Breed,
    val age: Int
) {
    constructor(petDto: PetDto) : this(
        name = petDto.name,
        breed = petDto.breed,
        age = petDto.age
    )
}
