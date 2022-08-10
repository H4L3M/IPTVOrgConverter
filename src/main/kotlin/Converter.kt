import backend.getData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import model.*
import java.io.File
import java.lang.reflect.Type

private const val DESKTOP = "/home/halem/Desktop"

private const val CHANNELS = "https://iptv-org.github.io/api/channels.json"
private const val STREAMS = "https://iptv-org.github.io/api/streams.json"

val gson: Gson = Gson()
val pretty: Gson = GsonBuilder().setPrettyPrinting().create()
private val channelListType: Type? = object : TypeToken<List<GitChannel>?>() {}.type
val channels: List<GitChannel> = gson.fromJson(getData(CHANNELS), channelListType)

private val streamListType: Type? = object : TypeToken<List<GitStream>?>() {}.type
val streams: List<GitStream> = gson.fromJson(getData(STREAMS), streamListType)

val arabCountries = listOf(
    "AE", "BH", "DJ", "DZ", "EG", "IQ", "JO", "KM", "KW", "LB", "LY", "MA", "MR", "OM", "PS", "QA",
    "SA", "SD", "SO", "SY", "TN", "YE"
)

object Converter {

    fun convert() {

        val list = mutableListOf<EliteChannel>()

        var eliteChannel = EliteChannel()


        for (country in arabCountries) {
            channels.forEachIndexed { id, channel ->
                if (channel.country!!.contains(country)) {


                    var streamUrl = ""
                    var status = ""
                    var category = ""

                    if (!channel.categories.isNullOrEmpty()) {
                        category = channel.categories[0].toString()
                    }

                    if (streamUrl.isEmpty()) {
                        status = "offline"
                    }

                    println(channel.name)

                    streams.forEachIndexed { _, stream ->

//                        if (stream.status.equals("online")) {
                        if (stream.channel == channel.id) {
                            println(stream.url)
                            streamUrl = stream.url.toString()
                            status = stream.status.toString()
                        }

                        eliteChannel = EliteChannel(
                            id = id,
                            name = Name(ar = "", en = channel.name),
                            logo = channel.logo!!,
                            code = Code(country = channel.country, category = category, `package` = ""),
                            userAgent = "",
                            stream = streamUrl,
                            status = status
                        )
//                        }
                    }

                    list.add(eliteChannel)

                }
            }
            val str = pretty.toJson(list)

            try {
                File(DESKTOP, "arb-pretty.json").writeText(text = buildString { append(str) })
                print("file created")
            } catch (e: Exception) {
                print("cause : ${e.cause}")
            }
        }
    }
}