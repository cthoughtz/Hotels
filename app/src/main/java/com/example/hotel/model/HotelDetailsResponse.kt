package com.example.hotel.model

import com.google.gson.annotations.SerializedName
data class HotelDetailsResponse(
    @SerializedName("result")
    val result: String?,
    @SerializedName("data")
    val data: Data?,
    @SerializedName("transportation")
    val transportation: Transportation?,
    @SerializedName("neighborhood")
    val neighborhood: Neighborhood?
) {
    data class Data(
        @SerializedName("body")
        val body: Body?,
        @SerializedName("common")
        val common: Common?
    ) {
        data class Body(
            @SerializedName("pdpHeader")
            val pdpHeader: PdpHeader?,
            @SerializedName("overview")
            val overview: Overview?,
            @SerializedName("hotelWelcomeRewards")
            val hotelWelcomeRewards: HotelWelcomeRewards?,
            @SerializedName("propertyDescription")
            val propertyDescription: PropertyDescription?,
            @SerializedName("guestReviews")
            val guestReviews: GuestReviews?,
            @SerializedName("atAGlance")
            val atAGlance: AtAGlance?,
            @SerializedName("amenities")
            val amenities: List<Amenity?>?,
            @SerializedName("smallPrint")
            val smallPrint: SmallPrint?,
            @SerializedName("specialFeatures")
            val specialFeatures: SpecialFeatures?,
            @SerializedName("miscellaneous")
            val miscellaneous: Miscellaneous?,
            @SerializedName("pageInfo")
            val pageInfo: PageInfo?,
            @SerializedName("trustYouReviewsCredit")
            val trustYouReviewsCredit: Boolean?,
            @SerializedName("hotelBadge")
            val hotelBadge: HotelBadge?
        ) {
            data class PdpHeader(
                @SerializedName("hotelId")
                val hotelId: String?,
                @SerializedName("destinationId")
                val destinationId: String?,
                @SerializedName("pointOfSaleId")
                val pointOfSaleId: String?,
                @SerializedName("currencyCode")
                val currencyCode: String?,
                @SerializedName("occupancyKey")
                val occupancyKey: String?,
                @SerializedName("hotelLocation")
                val hotelLocation: HotelLocation?
            ) {
                data class HotelLocation(
                    @SerializedName("coordinates")
                    val coordinates: Coordinates?,
                    @SerializedName("resolvedLocation")
                    val resolvedLocation: String?,
                    @SerializedName("locationName")
                    val locationName: String?
                ) {
                    data class Coordinates(
                        @SerializedName("latitude")
                        val latitude: Double?,
                        @SerializedName("longitude")
                        val longitude: Double?
                    )
                }
            }

            data class Overview(
                @SerializedName("overviewSections")
                val overviewSections: List<OverviewSection?>?
            ) {
                data class OverviewSection(
                    @SerializedName("title")
                    val title: String?,
                    @SerializedName("type")
                    val type: String?,
                    @SerializedName("content")
                    val content: List<String?>?,
                    @SerializedName("contentType")
                    val contentType: String?
                )
            }

            data class HotelWelcomeRewards(
                @SerializedName("applies")
                val applies: Boolean?,
                @SerializedName("info")
                val info: String?
            )

            data class PropertyDescription(
                @SerializedName("clientToken")
                val clientToken: String?,
                @SerializedName("address")
                val address: Address?,
                @SerializedName("priceMatchEnabled")
                val priceMatchEnabled: Boolean?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("starRatingTitle")
                val starRatingTitle: String?,
                @SerializedName("starRating")
                val starRating: Double?,
                @SerializedName("featuredPrice")
                val featuredPrice: FeaturedPrice?,
                @SerializedName("mapWidget")
                val mapWidget: MapWidget?,
                @SerializedName("roomTypeNames")
                val roomTypeNames: List<String?>?,
                @SerializedName("tagline")
                val tagline: List<String?>?,
                @SerializedName("freebies")
                val freebies: List<String?>?
            ) {
                data class Address(
                    @SerializedName("countryName")
                    val countryName: String?,
                    @SerializedName("cityName")
                    val cityName: String?,
                    @SerializedName("postalCode")
                    val postalCode: String?,
                    @SerializedName("provinceName")
                    val provinceName: String?,
                    @SerializedName("addressLine1")
                    val addressLine1: String?,
                    @SerializedName("countryCode")
                    val countryCode: String?,
                    @SerializedName("pattern")
                    val pattern: String?,
                    @SerializedName("fullAddress")
                    val fullAddress: String?
                )

                data class FeaturedPrice(
                    @SerializedName("beforePriceText")
                    val beforePriceText: String?,
                    @SerializedName("afterPriceText")
                    val afterPriceText: String?,
                    @SerializedName("pricingAvailability")
                    val pricingAvailability: String?,
                    @SerializedName("pricingTooltip")
                    val pricingTooltip: String?,
                    @SerializedName("currentPrice")
                    val currentPrice: CurrentPrice?,
                    @SerializedName("taxInclusiveFormatting")
                    val taxInclusiveFormatting: Boolean?,
                    @SerializedName("bookNowButton")
                    val bookNowButton: Boolean?
                ) {
                    data class CurrentPrice(
                        @SerializedName("formatted")
                        val formatted: String?,
                        @SerializedName("plain")
                        val plain: Double?
                    )
                }

                data class MapWidget(
                    @SerializedName("staticMapUrl")
                    val staticMapUrl: String?
                )
            }

            data class GuestReviews(
                @SerializedName("brands")
                val brands: Brands?,
                @SerializedName("trustYouReviews")
                val trustYouReviews: List<TrustYouReview?>?
            ) {
                data class Brands(
                    @SerializedName("scale")
                    val scale: Double?,
                    @SerializedName("formattedScale")
                    val formattedScale: String?,
                    @SerializedName("rating")
                    val rating: Double?,
                    @SerializedName("formattedRating")
                    val formattedRating: String?,
                    @SerializedName("lowRating")
                    val lowRating: Boolean?,
                    @SerializedName("badgeText")
                    val badgeText: String?,
                    @SerializedName("total")
                    val total: Int?
                )

                data class TrustYouReview(
                    @SerializedName("categoryName")
                    val categoryName: String?,
                    @SerializedName("percentage")
                    val percentage: String?,
                    @SerializedName("text")
                    val text: String?,
                    @SerializedName("sentiment")
                    val sentiment: String?
                )
            }

            data class AtAGlance(
                @SerializedName("keyFacts")
                val keyFacts: KeyFacts?,
                @SerializedName("travellingOrInternet")
                val travellingOrInternet: TravellingOrInternet?,
                @SerializedName("transportAndOther")
                val transportAndOther: TransportAndOther?
            ) {
                data class KeyFacts(
                    @SerializedName("hotelSize")
                    val hotelSize: List<String?>?,
                    @SerializedName("arrivingLeaving")
                    val arrivingLeaving: List<String?>?,
                    @SerializedName("specialCheckInInstructions")
                    val specialCheckInInstructions: List<Any?>?,
                    @SerializedName("requiredAtCheckIn")
                    val requiredAtCheckIn: List<String?>?
                )

                data class TravellingOrInternet(
                    @SerializedName("travelling")
                    val travelling: Travelling?,
                    @SerializedName("internet")
                    val internet: List<String?>?
                ) {
                    data class Travelling(
                        @SerializedName("children")
                        val children: List<Any?>?,
                        @SerializedName("pets")
                        val pets: List<String?>?,
                        @SerializedName("extraPeople")
                        val extraPeople: List<Any?>?
                    )
                }

                data class TransportAndOther(
                    @SerializedName("transport")
                    val transport: Transport?,
                    @SerializedName("otherInformation")
                    val otherInformation: List<String?>?,
                    @SerializedName("otherInclusions")
                    val otherInclusions: List<Any?>?
                ) {
                    data class Transport(
                        @SerializedName("transfers")
                        val transfers: List<Any?>?,
                        @SerializedName("parking")
                        val parking: List<String?>?,
                        @SerializedName("offsiteTransfer")
                        val offsiteTransfer: List<Any?>?
                    )
                }
            }

            data class Amenity(
                @SerializedName("heading")
                val heading: String?,
                @SerializedName("listItems")
                val listItems: List<Items?>?
            ) {
                data class Items(
                    @SerializedName("heading")
                    val heading: String?,
                    @SerializedName("listItems")
                    val listItems: List<String?>?
                )
            }

            data class SmallPrint(
                @SerializedName("alternativeNames")
                val alternativeNames: List<String?>?,
                @SerializedName("mandatoryFees")
                val mandatoryFees: List<String?>?,
                @SerializedName("optionalExtras")
                val optionalExtras: List<String?>?,
                @SerializedName("policies")
                val policies: List<String?>?,
                @SerializedName("mandatoryTaxesOrFees")
                val mandatoryTaxesOrFees: Boolean?,
                @SerializedName("display")
                val display: Boolean?
            )

            data class SpecialFeatures(
                @SerializedName("sections")
                val sections: List<Section?>?
            ) {
                data class Section(
                    @SerializedName("heading")
                    val heading: String?,
                    @SerializedName("freeText")
                    val freeText: String?,
                    @SerializedName("listItems")
                    val listItems: List<Any?>?,
                    @SerializedName("subsections")
                    val subsections: List<Any?>?
                )
            }

            data class Miscellaneous(
                @SerializedName("pimmsAttributes")
                val pimmsAttributes: String?,
                @SerializedName("showLegalInfoForStrikethroughPrices")
                val showLegalInfoForStrikethroughPrices: Boolean?
            )

            data class PageInfo(
                @SerializedName("pageType")
                val pageType: String?,
                @SerializedName("errors")
                val errors: List<Error?>?,
                @SerializedName("errorKeys")
                val errorKeys: List<String?>?
            ) {
                data class Error(
                    @SerializedName("fieldName")
                    val fieldName: String?,
                    @SerializedName("errorMessages")
                    val errorMessages: List<String?>?
                )
            }

            data class HotelBadge(
                @SerializedName("type")
                val type: String?,
                @SerializedName("label")
                val label: String?,
                @SerializedName("tooltipTitle")
                val tooltipTitle: String?,
                @SerializedName("tooltipText")
                val tooltipText: String?
            )
        }

        data class Common(
            @SerializedName("pointOfSale")
            val pointOfSale: PointOfSale?,
            @SerializedName("tracking")
            val tracking: Tracking?
        ) {
            data class PointOfSale(
                @SerializedName("numberSeparators")
                val numberSeparators: String?,
                @SerializedName("brandName")
                val brandName: String?
            )

            data class Tracking(
                @SerializedName("omniture")
                val omniture: Omniture?,
                @SerializedName("pageViewBeaconUrl")
                val pageViewBeaconUrl: String?
            ) {
                data class Omniture(
                    @SerializedName("s.prop34")
                    val sProp34: String?,
                    @SerializedName("s.eVar69")
                    val sEVar69: String?,
                    @SerializedName("s.currencyCode")
                    val sCurrencyCode: String?,
                    @SerializedName("s.eVar16")
                    val sEVar16: String?,
                    @SerializedName("s.products")
                    val sProducts: String?,
                    @SerializedName("s.eVar29")
                    val sEVar29: String?,
                    @SerializedName("s.eVar40")
                    val sEVar40: String?,
                    @SerializedName("s.eVar95")
                    val sEVar95: String?,
                    @SerializedName("s.eVar41")
                    val sEVar41: String?,
                    @SerializedName("s.eVar31")
                    val sEVar31: String?,
                    @SerializedName("s.eVar4")
                    val sEVar4: String?,
                    @SerializedName("s.eVar43")
                    val sEVar43: String?,
                    @SerializedName("s.eVar32")
                    val sEVar32: String?,
                    @SerializedName("s.eVar34")
                    val sEVar34: String?,
                    @SerializedName("s.eVar13")
                    val sEVar13: String?,
                    @SerializedName("s.server")
                    val sServer: String?,
                    @SerializedName("s.prop28")
                    val sProp28: String?,
                    @SerializedName("s.prop27")
                    val sProp27: String?,
                    @SerializedName("s.prop5")
                    val sProp5: String?,
                    @SerializedName("s.eVar80")
                    val sEVar80: String?,
                    @SerializedName("s.prop48")
                    val sProp48: String?,
                    @SerializedName("s.prop36")
                    val sProp36: String?,
                    @SerializedName("s.eVar93")
                    val sEVar93: String?
                )
            }
        }
    }

    data class Transportation(
        @SerializedName("transportLocations")
        val transportLocations: List<TransportLocation?>?
    ) {
        data class TransportLocation(
            @SerializedName("category")
            val category: String?,
            @SerializedName("locations")
            val locations: List<Location?>?
        ) {
            data class Location(
                @SerializedName("name")
                val name: String?,
                @SerializedName("distance")
                val distance: String?,
                @SerializedName("distanceInTime")
                val distanceInTime: String?
            )
        }
    }

    data class Neighborhood(
        @SerializedName("neighborhoodName")
        val neighborhoodName: String?
    )
}