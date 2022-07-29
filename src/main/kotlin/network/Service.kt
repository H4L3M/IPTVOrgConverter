package network

import java.net.URL

private const val CHANNELS = "https://iptv-org.github.io/api/channels.json"
private const val STREAMS = "https://iptv-org.github.io/api/streams.json"

fun getChannels() = URL(CHANNELS).readText()
fun getStreams() = URL(STREAMS).readText()