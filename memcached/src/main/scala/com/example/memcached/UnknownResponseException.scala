package com.example.memcached

class UnknownResponseException(val commandCode:Int) extends IllegalArgumentException("Unknown Response Exception")



