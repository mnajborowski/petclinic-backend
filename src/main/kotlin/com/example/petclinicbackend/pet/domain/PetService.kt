package com.example.petclinicbackend.pet.domain

import com.example.petclinicbackend.pet.infrastructure.PetRepository
import com.example.petclinicbackend.pet.domain.model.Pet
import com.example.petclinicbackend.pet.api.PetDto
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PetService(private val petRepository: PetRepository) {
    fun getAllPets(): List<Pet> = petRepository.findAll()

    fun getPetById(id: String): Pet = petRepository.findByIdOrNull(ObjectId(id))
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Pet with id $id doesn't exist in database.")

    fun createPet(petDto: PetDto): Pet = petRepository.save(Pet(petDto))

    fun updatePet(id: String, petDto: PetDto): Pet = getPetById(id).copy(
        name = petDto.name,
        breed = petDto.breed,
        age = petDto.age
    ).let { petRepository.save(it) }

    fun deletePet(id: String) {
        petRepository.deleteById(ObjectId(id))
    }
}
