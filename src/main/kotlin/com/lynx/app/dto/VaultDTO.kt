package com.lynx.app.dto

import com.lynx.app.model.Login

data class VaultDTO(
  val email: String,
  val password: String,
  val logins: MutableSet<Login>
)