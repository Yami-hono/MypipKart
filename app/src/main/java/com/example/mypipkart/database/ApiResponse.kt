package com.example.mypipkart.database

data class ApiResponse(
    val responseMsg: ResponseMsg,
    val responseResult: ResponseResult
)

data class Announcement(
    val id: String,
    val imageUrl: String,
    val isMajorService: Boolean,
    val name: String
)

data class Banner(
    val id: String,
    val imageUrl: String,
    val isMajorService: Boolean,
    val name: String
)

data class Data(
    val announcements: List<Announcement>,
    val bannerList: List<Banner>,
    val nearByGarages: List<NearByGarage>,
    val offerOnAmc: List<OfferOnAmc>,
    val offers: List<Any>,
    val product: Product,
    val servicePackages: List<Any>,
    val services: List<Service>,
    val todayFeatures: List<TodayFeature>,
    val trendingProducts: ArrayList<TrendingProduct>,
    val upcomingEvents: List<UpcomingEvent>
)

data class ProductArray(
    val discount: Int,
    val id: Int,
    val imageUrl: String,
    val isEcom: Boolean,
    val name: String
)

data class ResponseMsg(
    val isError: Boolean,
    val isWarning: Boolean,
    val responseMsOther: ResponseMsOther
)

data class ResponseMsOther(
    val msgArray: String
)

data class ResponseResult(
    val result: Result
)

data class UpcomingEvent(
    val id: Int,
    val imageUrl: String,
    val name: String
)

data class TrendingProduct(
    val attributes: List<String>,
    val discount: Int,
    val id: Int,
    val imageUrl: String,
    val isEcom: Boolean,
    val name: String
)

data class TodayFeature(
    val id: String,
    val imageUrl: String,
    val isMajorService: Boolean,
    val name: String
)

data class Service(
    val id: Int,
    val isMajorService: Boolean,
    val name: String,
    val solidBgImg: String,
    val typeId: String,
    val whiteBgImg: String
)

data class Result(
    val data: Data
)

data class ProductBanner(
    val imageUrl: String,
    val name: String
)

data class Product(
    val productArray: List<ProductArray>,
    val productBanner: ArrayList<ProductBanner>
)

data class OfferOnAmc(
    val description: String,
    val discountPercent: Int,
    val id: Int,
    val imageUrl: String,
    val name: String
)

data class NearByGarage(
    val brandUrl: String,
    val distance: Double,
    val id: Int,
    val imageUrl: String,
    val isClose: Boolean,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val rateRatio: Int
)