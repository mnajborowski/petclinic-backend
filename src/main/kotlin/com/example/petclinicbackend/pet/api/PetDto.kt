package com.example.petclinicbackend.pet.api

import com.example.petclinicbackend.pet.domain.model.value.Breed

data class PetDto(
    val name: String,
    val breed: Breed,
    val age: Int
)
