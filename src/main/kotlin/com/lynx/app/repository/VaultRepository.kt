package com.lynx.app.repository

import com.lynx.app.model.Vault
import org.springframework.data.jpa.repository.JpaRepository

interface VaultRepository : JpaRepository<Vault, Long> {

  fun findByName(name: String): Vault?
}