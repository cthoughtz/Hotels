package com.example.hotel.model

import com.google.gson.annotations.SerializedName
data class HotelListResponse(
    @SerializedName("result")
    val result: String?,
    @SerializedName("data")
    val data: Data?
) {
    data class Data(
        @SerializedName("body")
        val body: Body?,
        @SerializedName("common")
        val common: Common?
    ) {
        data class Body(
            @SerializedName("header")
            val header: String?,
            @SerializedName("query")
            val query: Query?,
            @SerializedName("searchResults")
            val searchResults: SearchResults?,
            @SerializedName("sortResults")
            val sortResults: SortResults?,
            @SerializedName("filters")
            val filters: Filters?,
            @SerializedName("pointOfSale")
            val pointOfSale: PointOfSale?,
            @SerializedName("miscellaneous")
            val miscellaneous: Miscellaneous?,
            @SerializedName("pageInfo")
            val pageInfo: PageInfo?
        ) {
            data class Query(
                @SerializedName("destination")
                val destination: Destination?
            ) {
                data class Destination(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("value")
                    val value: String?,
                    @SerializedName("resolvedLocation")
                    val resolvedLocation: String?
                )
            }

            data class SearchResults(
                @SerializedName("totalCount")
                val totalCount: Int?,
                @SerializedName("results")
                val results: List<Result?>?,
                @SerializedName("pagination")
                val pagination: Pagination?
            ) {
                data class Result(
                    @SerializedName("id")
                    val id: Int?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("thumbnailUrl")
                    val thumbnailUrl: String?,
                    @SerializedName("starRating")
                    val starRating: Double?,
                    @SerializedName("address")
                    val address: Address?,
                    @SerializedName("guestReviews")
                    val guestReviews: GuestReviews?,
                    @SerializedName("landmarks")
                    val landmarks: List<Landmark?>?,
                    @SerializedName("ratePlan")
                    val ratePlan: RatePlan?,
                    @SerializedName("neighbourhood")
                    val neighbourhood: String?,
                    @SerializedName("deals")
                    val deals: Deals?,
                    @SerializedName("messaging")
                    val messaging: Messaging?,
                    @SerializedName("badging")
                    val badging: Badging?,
                    @SerializedName("pimmsAttributes")
                    val pimmsAttributes: String?,
                    @SerializedName("coordinate")
                    val coordinate: Coordinate?,
                    @SerializedName("providerType")
                    val providerType: String?,
                    @SerializedName("supplierHotelId")
                    val supplierHotelId: Int?
                ) {
                    data class Address(
                        @SerializedName("streetAddress")
                        val streetAddress: String?,
                        @SerializedName("extendedAddress")
                        val extendedAddress: String?,
                        @SerializedName("locality")
                        val locality: String?,
                        @SerializedName("postalCode")
                        val postalCode: String?,
                        @SerializedName("region")
                        val region: String?,
                        @SerializedName("countryName")
                        val countryName: String?,
                        @SerializedName("countryCode")
                        val countryCode: String?
                    )

                    data class GuestReviews(
                        @SerializedName("unformattedRating")
                        val unformattedRating: Double?,
                        @SerializedName("rating")
                        val rating: String?,
                        @SerializedName("total")
                        val total: Int?,
                        @SerializedName("scale")
                        val scale: Int?,
                        @SerializedName("badge")
                        val badge: String?,
                        @SerializedName("badgeText")
                        val badgeText: String?
                    )

                    data class Landmark(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("distance")
                        val distance: String?
                    )

                    data class RatePlan(
                        @SerializedName("price")
                        val price: Price?,
                        @SerializedName("features")
                        val features: Features?
                    ) {
                        data class Price(
                            @SerializedName("current")
                            val current: String?,
                            @SerializedName("exactCurrent")
                            val exactCurrent: Double?,
                            @SerializedName("old")
                            val old: String?
                        )

                        data class Features(
                            @SerializedName("paymentPreference")
                            val paymentPreference: Boolean?,
                            @SerializedName("noCCRequired")
                            val noCCRequired: Boolean?
                        )
                    }

                    class Deals(
                    )

                    class Messaging(
                    )

                    class Badging(
                    )

                    data class Coordinate(
                        @SerializedName("lat")
                        val lat: Double?,
                        @SerializedName("lon")
                        val lon: Double?
                    )
                }

                data class Pagination(
                    @SerializedName("currentPage")
                    val currentPage: Int?,
                    @SerializedName("pageGroup")
                    val pageGroup: String?,
                    @SerializedName("nextPageNumber")
                    val nextPageNumber: Int?,
                    @SerializedName("nextPageGroup")
                    val nextPageGroup: String?
                )
            }

            data class SortResults(
                @SerializedName("options")
                val options: List<Option?>?,
                @SerializedName("distanceOptionLandmarkId")
                val distanceOptionLandmarkId: Double?
            ) {
                data class Option(
                    @SerializedName("label")
                    val label: String?,
                    @SerializedName("itemMeta")
                    val itemMeta: String?,
                    @SerializedName("choices")
                    val choices: List<Choice?>?,
                    @SerializedName("enhancedChoices")
                    val enhancedChoices: List<Any?>?,
                    @SerializedName("selectedChoiceLabel")
                    val selectedChoiceLabel: String?
                ) {
                    data class Choice(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?,
                        @SerializedName("selected")
                        val selected: Boolean?
                    )
                }
            }

            data class Filters(
                @SerializedName("applied")
                val applied: Boolean?,
                @SerializedName("name")
                val name: Name?,
                @SerializedName("starRating")
                val starRating: StarRating?,
                @SerializedName("guestRating")
                val guestRating: GuestRating?,
                @SerializedName("landmarks")
                val landmarks: Landmarks?,
                @SerializedName("neighbourhood")
                val neighbourhood: Neighbourhood?,
                @SerializedName("accommodationType")
                val accommodationType: AccommodationType?,
                @SerializedName("facilities")
                val facilities: Facilities?,
                @SerializedName("accessibility")
                val accessibility: Accessibility?,
                @SerializedName("themesAndTypes")
                val themesAndTypes: ThemesAndTypes?,
                @SerializedName("price")
                val price: Price?,
                @SerializedName("paymentPreference")
                val paymentPreference: PaymentPreference?,
                @SerializedName("welcomeRewards")
                val welcomeRewards: WelcomeRewards?
            ) {
                data class Name(
                    @SerializedName("item")
                    val item: Item?,
                    @SerializedName("autosuggest")
                    val autosuggest: Autosuggest?
                ) {
                    data class Item(
                        @SerializedName("value")
                        val value: String?
                    )

                    data class Autosuggest(
                        @SerializedName("additionalUrlParams")
                        val additionalUrlParams: AdditionalUrlParams?
                    ) {
                        data class AdditionalUrlParams(
                            @SerializedName("resolved-location")
                            val resolvedLocation: String?,
                            @SerializedName("q-destination")
                            val qDestination: String?,
                            @SerializedName("destination-id")
                            val destinationId: String?
                        )
                    }
                }

                data class StarRating(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("value")
                        val value: Int?
                    )
                }

                data class GuestRating(
                    @SerializedName("range")
                    val range: Range?
                ) {
                    data class Range(
                        @SerializedName("min")
                        val min: Min?,
                        @SerializedName("max")
                        val max: Max?
                    ) {
                        data class Min(
                            @SerializedName("defaultValue")
                            val defaultValue: Double?
                        )

                        data class Max(
                            @SerializedName("defaultValue")
                            val defaultValue: Double?
                        )
                    }
                }

                data class Landmarks(
                    @SerializedName("selectedOrder")
                    val selectedOrder: List<Any?>?,
                    @SerializedName("items")
                    val items: List<Item?>?,
                    @SerializedName("distance")
                    val distance: List<Any?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class Neighbourhood(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: Int?
                    )
                }

                data class AccommodationType(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class Facilities(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class Accessibility(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class ThemesAndTypes(
                    @SerializedName("applied")
                    val applied: Boolean?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class Price(
                    @SerializedName("label")
                    val label: String?,
                    @SerializedName("range")
                    val range: Range?,
                    @SerializedName("multiplier")
                    val multiplier: Int?
                ) {
                    data class Range(
                        @SerializedName("min")
                        val min: Min?,
                        @SerializedName("max")
                        val max: Max?,
                        @SerializedName("increments")
                        val increments: Int?
                    ) {
                        data class Min(
                            @SerializedName("defaultValue")
                            val defaultValue: Int?
                        )

                        data class Max(
                            @SerializedName("defaultValue")
                            val defaultValue: Int?
                        )
                    }
                }

                data class PaymentPreference(
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }

                data class WelcomeRewards(
                    @SerializedName("label")
                    val label: String?,
                    @SerializedName("items")
                    val items: List<Item?>?
                ) {
                    data class Item(
                        @SerializedName("label")
                        val label: String?,
                        @SerializedName("value")
                        val value: String?
                    )
                }
            }

            data class PointOfSale(
                @SerializedName("currency")
                val currency: Currency?
            ) {
                data class Currency(
                    @SerializedName("code")
                    val code: String?,
                    @SerializedName("symbol")
                    val symbol: String?,
                    @SerializedName("separators")
                    val separators: String?,
                    @SerializedName("format")
                    val format: String?
                )
            }

            data class Miscellaneous(
                @SerializedName("pageViewBeaconUrl")
                val pageViewBeaconUrl: String?
            )

            data class PageInfo(
                @SerializedName("pageType")
                val pageType: String?
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
                val omniture: Omniture?
            ) {
                data class Omniture(
                    @SerializedName("s.prop33")
                    val sProp33: String?,
                    @SerializedName("s.prop32")
                    val sProp32: String?,
                    @SerializedName("s.prop74")
                    val sProp74: String?,
                    @SerializedName("s.products")
                    val sProducts: String?,
                    @SerializedName("s.eVar16")
                    val sEVar16: String?,
                    @SerializedName("s.eVar40")
                    val sEVar40: String?,
                    @SerializedName("s.eVar41")
                    val sEVar41: String?,
                    @SerializedName("s.eVar63")
                    val sEVar63: String?,
                    @SerializedName("s.eVar42")
                    val sEVar42: String?,
                    @SerializedName("s.eVar4")
                    val sEVar4: String?,
                    @SerializedName("s.eVar43")
                    val sEVar43: String?,
                    @SerializedName("s.eVar2")
                    val sEVar2: String?,
                    @SerializedName("s.eVar24")
                    val sEVar24: String?,
                    @SerializedName("s.eVar7")
                    val sEVar7: String?,
                    @SerializedName("s.server")
                    val sServer: String?,
                    @SerializedName("s.eVar6")
                    val sEVar6: String?,
                    @SerializedName("s.prop29")
                    val sProp29: String?,
                    @SerializedName("s.prop27")
                    val sProp27: String?,
                    @SerializedName("s.eVar9")
                    val sEVar9: String?,
                    @SerializedName("s.eVar69")
                    val sEVar69: String?,
                    @SerializedName("s.currencyCode")
                    val sCurrencyCode: String?,
                    @SerializedName("s.eVar29")
                    val sEVar29: String?,
                    @SerializedName("s.prop9")
                    val sProp9: String?,
                    @SerializedName("s.prop8")
                    val sProp8: String?,
                    @SerializedName("s.eVar95")
                    val sEVar95: String?,
                    @SerializedName("s.prop7")
                    val sProp7: String?,
                    @SerializedName("s.eVar31")
                    val sEVar31: String?,
                    @SerializedName("s.eVar32")
                    val sEVar32: String?,
                    @SerializedName("s.eVar33")
                    val sEVar33: String?,
                    @SerializedName("s.eVar34")
                    val sEVar34: String?,
                    @SerializedName("s.eVar13")
                    val sEVar13: String?,
                    @SerializedName("s.prop18")
                    val sProp18: String?,
                    @SerializedName("s.prop5")
                    val sProp5: String?,
                    @SerializedName("s.prop15")
                    val sProp15: String?,
                    @SerializedName("s.prop3")
                    val sProp3: String?,
                    @SerializedName("s.prop14")
                    val sProp14: String?,
                    @SerializedName("s.prop36")
                    val sProp36: String?,
                    @SerializedName("s.eVar93")
                    val sEVar93: String?,
                    @SerializedName("s.prop2")
                    val sProp2: String?
                )
            }
        }
    }
}

