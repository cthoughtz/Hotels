package com.example.hotel.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("term")
    val term: String?,
    @SerializedName("moresuggestions")
    val moresuggestions: Int?,
    @SerializedName("autoSuggestInstance")
    val autoSuggestInstance: String?,
    @SerializedName("trackingID")
    val trackingID: String?,
    @SerializedName("misspellingfallback")
    val misspellingfallback: Boolean?,
    @SerializedName("suggestions")
    val suggestions: List<Suggestions>?
)

data class Suggestions(
    @SerializedName("0")
    val zero: Zero?,
    @SerializedName("1")
    val one: One?,
    @SerializedName("2")
    val two: Two?,
    @SerializedName("3")
    val three: Three?
)


data class Zero(
    @SerializedName("group")
    val group: String?,
    @SerializedName("entities")
    val entities: List<Entities>?
)

data class One(
    @SerializedName("group")
    val group:String?,
    @SerializedName("entities")
    val entities: List<EntitiesOne>?
)


data class Two(
    @SerializedName("group")
    val group:String?,
    @SerializedName("entities")
    val entities: List<EntitiesTwo>?
)

data class Three(
    @SerializedName("group")
    val group:String?,
    @SerializedName("entities")
    val testing: List<EntitiesThree>?
)


data class Entities(
    @SerializedName("group")
    val group: String?,
    @SerializedName("0")
    val entityZero: EntityZero?,
    @SerializedName("1")
    val entityOne: EntityOne?,
    @SerializedName("2")
    val entityTwo: EntityTwo?,
    @SerializedName("3")
    val entityThree: EntityThree?,
    @SerializedName("4")
    val entityFour: EntityFour?,
    @SerializedName("5")
    val entityFive: EntityFive?
)


data class EntityZero(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntityOne(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntityTwo(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntityThree(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntityFour(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntityFive(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

// Suggesstions - Entities One
data class EntitiesOne(
    @SerializedName("group")
    val group: String?,
    @SerializedName("0")
    val entityZero0: EntityZeroZ?,
    @SerializedName("1")
    val entityOne1: EntityOneO?,
    @SerializedName("2")
    val entityTwo2: EntityTwoT?
)


data class EntityZeroZ(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)
data class EntityOneO(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)
data class EntityTwoT(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)


// suggestions EntitiesTwo
data class EntitiesTwo(

    @SerializedName("0")
    val entitiesZero: EntitiesTwoZero?,
    @SerializedName("1")
    val entitiesOne: EntitiesTwoOne?,
    @SerializedName("2")
    val entitiesTwo: EntitiesTwoTwo?
)

data class EntitiesTwoZero(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)
data class EntitiesTwoOne(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)
data class EntitiesTwoTwo(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)



// Suggesstions EntitiesFour
data class EntitiesThree(
    @SerializedName("0")
    val entitiesThreeZ: EntitiesThreeZ,
    @SerializedName("1")
    val entitiesThreeO: EntitiesThreeO,
    @SerializedName("2")
    val entitiesThreeT: EntitiesThreeT
)

data class EntitiesThreeZ(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntitiesThreeO(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)

data class EntitiesThreeT(
    @SerializedName("geoId")
    val geoId: String?,
    @SerializedName("destinationId")
    val destinationId: String?,
    @SerializedName("landmarkCityDestinationId")
    val landmarkCityDestinationId: String? = null,
    @SerializedName("type")
    val type: String?,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("redirectPage")
    val redirectPage: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longtitude")
    val longitude:String?,
    @SerializedName("name")
    val name: String?
)