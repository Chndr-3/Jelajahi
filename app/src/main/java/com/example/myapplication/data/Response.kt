package com.example.jelajah.data

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Response")
	val response: List<ResponseItem>
)

data class Cym(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Maps(

	@field:SerializedName("openStreetMaps")
	val openStreetMaps: String,

	@field:SerializedName("googleMaps")
	val googleMaps: String
)

data class ResponseItem(

	@field:SerializedName("capital")
	val capital: List<String>,

	@field:SerializedName("flag")
	val flag: String,

	@field:SerializedName("independent")
	val independent: Boolean,

	@field:SerializedName("landlocked")
	val landlocked: Boolean,

	@field:SerializedName("borders")
	val borders: List<String>,

	@field:SerializedName("postalCode")
	val postalCode: PostalCode,

	@field:SerializedName("flags")
	val flags: Flags,

	@field:SerializedName("capitalInfo")
	val capitalInfo: CapitalInfo,

	@field:SerializedName("ccn3")
	val ccn3: String,

	@field:SerializedName("coatOfArms")
	val coatOfArms: CoatOfArms,

	@field:SerializedName("demonyms")
	val demonyms: Demonyms,

	@field:SerializedName("fifa")
	val fifa: String,

	@field:SerializedName("cioc")
	val cioc: String,

	@field:SerializedName("car")
	val car: Car,

	@field:SerializedName("translations")
	val translations: Translations,

	@field:SerializedName("altSpellings")
	val altSpellings: List<String>,

	@field:SerializedName("area")
	val area: Any,

	@field:SerializedName("languages")
	val languages: Languages,

	@field:SerializedName("maps")
	val maps: Maps,

	@field:SerializedName("subregion")
	val subregion: String,

	@field:SerializedName("idd")
	val idd: Idd,

	@field:SerializedName("tld")
	val tld: List<String>,

	@field:SerializedName("unMember")
	val unMember: Boolean,

	@field:SerializedName("gini")
	val gini: Gini,

	@field:SerializedName("continents")
	val continents: List<String>,

	@field:SerializedName("population")
	val population: Int,

	@field:SerializedName("startOfWeek")
	val startOfWeek: String,

	@field:SerializedName("timezones")
	val timezones: List<String>,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("cca3")
	val cca3: String,

	@field:SerializedName("region")
	val region: String,

	@field:SerializedName("latlng")
	val latlng: List<Any>,

	@field:SerializedName("cca2")
	val cca2: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("currencies")
	val currencies: Currencies
)

data class Hun(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Idd(

	@field:SerializedName("suffixes")
	val suffixes: List<String>,

	@field:SerializedName("root")
	val root: String
)

data class Per(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Bre(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Jpn(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Ind(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Translations(

	@field:SerializedName("hun")
	val hun: Hun,

	@field:SerializedName("swe")
	val swe: Swe,

	@field:SerializedName("zho")
	val zho: Zho,

	@field:SerializedName("est")
	val est: Est,

	@field:SerializedName("fin")
	val fin: Fin,

	@field:SerializedName("pol")
	val pol: Pol,

	@field:SerializedName("kor")
	val kor: Kor,

	@field:SerializedName("ces")
	val ces: Ces,

	@field:SerializedName("tur")
	val tur: Tur,

	@field:SerializedName("ara")
	val ara: Ara,

	@field:SerializedName("rus")
	val rus: Rus,

	@field:SerializedName("por")
	val por: Por,

	@field:SerializedName("bre")
	val bre: Bre,

	@field:SerializedName("fra")
	val fra: Fra,

	@field:SerializedName("deu")
	val deu: Deu,

	@field:SerializedName("ita")
	val ita: Ita,

	@field:SerializedName("per")
	val per: Per,

	@field:SerializedName("spa")
	val spa: Spa,

	@field:SerializedName("urd")
	val urd: Urd,

	@field:SerializedName("nld")
	val nld: Nld,

	@field:SerializedName("jpn")
	val jpn: Jpn,

	@field:SerializedName("hrv")
	val hrv: Hrv,

	@field:SerializedName("srp")
	val srp: Srp,

	@field:SerializedName("slk")
	val slk: Slk,

	@field:SerializedName("cym")
	val cym: Cym
)

data class Car(

	@field:SerializedName("side")
	val side: String,

	@field:SerializedName("signs")
	val signs: List<String>
)

data class Fin(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Slk(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Swe(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Ita(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Srp(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Tur(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Kor(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class IDR(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("name")
	val name: String
)

data class Nld(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Zho(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Spa(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Ces(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Demonyms(

	@field:SerializedName("fra")
	val fra: Fra,

	@field:SerializedName("eng")
	val eng: Eng
)

data class Por(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Est(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Gini(

	@field:SerializedName("2019")
	val jsonMember2019: Any
)

data class Name(

	@field:SerializedName("nativeName")
	val nativeName: NativeName,

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Deu(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Languages(

	@field:SerializedName("ind")
	val ind: String
)

data class NativeName(

	@field:SerializedName("ind")
	val ind: Ind
)

data class Flags(

	@field:SerializedName("svg")
	val svg: String,

	@field:SerializedName("png")
	val png: String,

	@field:SerializedName("alt")
	val alt: String
)

data class Rus(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Hrv(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Eng(

	@field:SerializedName("f")
	val f: String,

	@field:SerializedName("m")
	val m: String
)

data class Ara(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Fra(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String,

	@field:SerializedName("f")
	val f: String,

	@field:SerializedName("m")
	val m: String
)

data class Urd(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class PostalCode(

	@field:SerializedName("regex")
	val regex: String,

	@field:SerializedName("format")
	val format: String
)

data class CoatOfArms(

	@field:SerializedName("svg")
	val svg: String,

	@field:SerializedName("png")
	val png: String
)

data class Pol(

	@field:SerializedName("common")
	val common: String,

	@field:SerializedName("official")
	val official: String
)

data class Currencies(

	@field:SerializedName("IDR")
	val iDR: IDR
)

data class CapitalInfo(

	@field:SerializedName("latlng")
	val latlng: List<Any>
)
