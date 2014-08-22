package com.example.memcached


class ComandFailedException(val msg:ServerResponse) 
extends IllegalStateException("Command Failed Exception command:"+msg.command+" status:"+msg.status)