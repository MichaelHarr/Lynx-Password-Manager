package com.lynx.app.service

import com.lynx.app.dto.VaultDTO
import com.lynx.app.model.Vault
import com.lynx.app.repository.VaultRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class VaultService(val vaultRepository: VaultRepository) {

  fun createVault(vaultDto: VaultDTO): Vault {
    val vault = Vault(vaultDto.email, vaultDto.password)
    return vaultRepository.save(vault)
  }

  fun getVaultByName(name: String): Vault? {
    val vault: Vault? = vaultRepository.findByEmail(name)
    return vault
  }

  fun getVaultById(vaultId: Long): Vault? {
    val vault: Optional<Vault> = vaultRepository.findById(vaultId)
    if (vault.isEmpty) {
      return null
    }
    return vault.get()
  }

  fun getAllVaults(): List<Vault> {
    return vaultRepository.findAll()
  }
}