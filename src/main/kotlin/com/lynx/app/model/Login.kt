package com.lynx.app.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.io.Serializable

@Entity
class Login(
  @Column(nullable = false)
  var website: String,

  @Column(nullable = false)
  var username: String,

  @Column(nullable = false)
  var password: String,

  @ManyToOne
  @JoinColumn(name = "vault_id")
  var vault: Vault
) : Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false)
  val id: Long? = null
}