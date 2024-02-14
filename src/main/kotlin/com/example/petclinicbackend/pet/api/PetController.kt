package com.example.petclinicbackend.pet.api

import com.example.petclinicbackend.pet.domain.model.Pet
import com.example.petclinicbackend.pet.domain.PetService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pets")
class PetController(private val petService: PetService) {
    @GetMapping
    fun getAllPets(): List<Pet> = petService.getAllPets()

    @GetMapping("{id}")
    fun getPet(@PathVariable id: String): Pet = petService.getPetById(id)

    @PostMapping
    fun createPet(@RequestBody petDto: PetDto): Pet = petService.createPet(petDto)

    @PutMapping("{id}")
    fun updatePet(
        @PathVariable id: String,
        @RequestBody petDto: PetDto
    ): Pet = petService.updatePet(id, petDto)

    @DeleteMapping("{id}")
    fun deletePet(@PathVariable id: String) {
        petService.deletePet(id)
    }
}
