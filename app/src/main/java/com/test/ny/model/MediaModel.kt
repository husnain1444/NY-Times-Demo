package com.test.ny.model

data class MediaModel(val type: String, val subtype: String, val `media-metadata`: List<MediaMetaDataModel>)

data class MediaMetaDataModel(val url: String, val format: String)
//type	:	image
//subtype	:
//media-metadata	{
//url	:	https://static01.nyt.com/images/2022/01/31/business/31tk/31tk-thumbStandard.jpg
//format	:	Standard Thumbnail
//height	:	75
//width	:	75
//}
