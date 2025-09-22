package com.lynx.app.dto

import com.lynx.app.model.Login

data class VaultDTO(
  val name: String,
  val password: String,
  val logins: MutableSet<Login>
)