package com.lynx.app.service

import com.lynx.app.dto.LoginDTO
import com.lynx.app.mapper.LoginMapper
import com.lynx.app.model.Login
import com.lynx.app.model.Vault
import com.lynx.app.repository.LoginRepository
import com.lynx.app.repository.VaultRepository
import org.springframework.stereotype.Service

@Service
class LoginService(val loginRepository: LoginRepository, val vaultRepository: VaultRepository, val loginMapper: LoginMapper) {

  fun createLogin(loginDto: LoginDTO, vaultId: Long): Login {
    val login = loginMapper.fromDTO(loginDto, vaultId)

    val vault: Vault = vaultRepository.findById(vaultId).get()
    login.vault = vault

    return loginRepository.save(login)
  }

  fun getLoginByWebsite(websiteName: String): List<Login> {
    val loginList: List<Login> = loginRepository.findByWebsite(websiteName)
    return loginList
  }


}