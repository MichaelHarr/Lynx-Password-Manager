package com.lynx.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.command.annotation.CommandScan


@SpringBootApplication
@CommandScan
class LynxApplication

fun main(args: Array<String>) {
	runApplication<LynxApplication>(*args)
}
