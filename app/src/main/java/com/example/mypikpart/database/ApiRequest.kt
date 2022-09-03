package com.example.mypikpart.database

data class ApiRequest(
    val objectHash:ObjectHash,
    val queryParamHash:QueryParamHash
)

data class ObjectHash(
    val latitude:Double,
    val longitude:Double,
    val vehicleId:Int
)

data class QueryParamHash(
    val actionId:String
)
/*

    "objectHash" : {
        "latitude":25.6256436,
        "longitude":83.0038971,
        "vehicleId": 2316
    },
    "queryParamHash" : {
        "actionId" : "homePageMob"
    }
}
 */