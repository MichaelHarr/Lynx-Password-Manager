package com.lynx.app.mapper

import com.lynx.app.dto.LoginDTO
import com.lynx.app.model.Login
import com.lynx.app.model.Vault
import com.lynx.app.service.VaultService
import org.springframework.stereotype.Component

@Component
class LoginMapper(private val vaultService: VaultService) {

  fun toDTO(login: Login): LoginDTO {
    val website: String = requireNotNull(login.website) { "Website not found" }
    val username: String = requireNotNull(login.username) { "Username not found" }
    val password: String = requireNotNull(login.password) { "Password not found" }

    return LoginDTO(website, username, password)
  }

  fun fromDTO(loginDTO: LoginDTO, vaultId: Long): Login {
    val vault: Vault = requireNotNull(vaultService.getVaultById(vaultId)) { "Vault not found" }
    return Login(loginDTO.websiteName, loginDTO.username, loginDTO.password, vault)
  }

}