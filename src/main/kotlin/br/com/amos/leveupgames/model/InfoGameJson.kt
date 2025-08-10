package br.com.amos.leveupgames.model

import com.google.gson.annotations.SerializedName

data class InfoGameJson(
    @SerializedName("titulo") val title: String?,
    @SerializedName("capa") val cover: String?,
    @SerializedName("preco") val price: Double?,
    @SerializedName("descricao") val description: String?)
