package com.lynx.app.mapper

import com.lynx.app.dto.VaultDTO
import com.lynx.app.model.Vault

class VaultMapper {

  fun fromDTO(vaultDto: VaultDTO): Vault? {
    return Vault(vaultDto.email, vaultDto.password)
  }

}