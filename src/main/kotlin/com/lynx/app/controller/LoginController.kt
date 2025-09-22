package com.lynx.app.controller

import com.lynx.app.dto.LoginDTO
import com.lynx.app.mapper.LoginMapper
import com.lynx.app.model.Login
import com.lynx.app.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vaults/{vaultId}/logins")
class LoginController(val loginService: LoginService, val loginMapper: LoginMapper) {

  @PostMapping
  fun addLogin(@RequestBody loginDto: LoginDTO, @PathVariable("vaultId") vaultId: Long): LoginDTO {
    val login: Login = loginService.createLogin(loginDto, vaultId)
    return loginMapper.toDTO(login)
  }

  @GetMapping
  fun getLoginByWebsite(@RequestParam("websiteName") websiteName: String, @PathVariable vaultId: String): List<Login> {
    val logins: List<Login> = loginService.getLoginByWebsite(websiteName)
    return logins
  }

}