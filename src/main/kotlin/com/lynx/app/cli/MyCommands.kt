package com.lynx.app.cli

import org.springframework.shell.command.annotation.Command
import org.springframework.stereotype.Component

@Component
@Command
class MyCommands {


  @Command(command = ["example"], description = "Example Command")
  fun example(): String {
    return "Hello World!"
  }

  @Command(command = ["login"], description = "Login into vault")
  fun login(): String {
    return "The pokemon is ditto"
  }
}