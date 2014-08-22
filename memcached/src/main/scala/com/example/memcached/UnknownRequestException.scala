package com.example.memcached

class UnknownRequestException(val request:ClientRequest) 
extends IllegalArgumentException("UnknownRequestException")