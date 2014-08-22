package com.example.memcached

import io.netty.channel.ChannelFuture


class FailedFutureException(val channelFuture:ChannelFuture) 
extends IllegalStateException("Failed Future Exception")