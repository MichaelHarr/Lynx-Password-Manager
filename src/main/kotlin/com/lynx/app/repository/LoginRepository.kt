package com.lynx.app.repository

import com.lynx.app.model.Login
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<Login, String> {

  fun findByWebsite(websiteName: String): List<Login>
}