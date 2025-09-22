package com.lynx.app.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.io.Serializable

@Entity
class Vault(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,

  @Column(nullable = false)
  var name: String? = null,

  @Column(nullable = false)
  var password: String? = null,

  @OneToMany(mappedBy = "vault", cascade = [(CascadeType.ALL)])
  var logins: MutableSet<Login> = mutableSetOf()
) : Serializable
