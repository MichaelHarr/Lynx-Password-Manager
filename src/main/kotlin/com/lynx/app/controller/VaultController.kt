package com.lynx.app.controller

import com.lynx.app.dto.VaultDTO
import com.lynx.app.model.Vault
import com.lynx.app.service.VaultService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class VaultController(val vaultService: VaultService) {

  @PostMapping("/vault")
  fun addVault(@RequestBody vaultDto: VaultDTO): Vault {
    return vaultService.createVault(vaultDto)
  }

  @GetMapping("/vault")
  fun getAllVaults(): List<Vault> {
    return vaultService.getAllVaults()
  }

  @GetMapping("/vault/{name}")
  fun getVaultByName(@PathVariable("name") name: String): Vault? {
    val vault: Vault? = vaultService.getVaultByName(name)
    return vault
  }

  @GetMapping("/vault/{id}")
  fun getVaultById(@PathVariable("id") id: String): Vault? {
    val vault: Vault? = vaultService.getVaultById(id.toLong())
    return vault
  }
}