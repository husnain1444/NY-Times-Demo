package com.test.ny.model

data class Section(val title: String, val url: String, val type: String,
                   val section: String, val subsection: String, val abstract: String,
                    val media: List<MediaModel>)

//uri	:	nyt://article/3517dad7-9ecf-5cdc-b252-44ee8d8d05f3
//url	:	https://www.nytimes.com/2022/01/31/business/media/new-york-times-wordle.html
//id	:	1000000081843935138-11-16T12:03:04.393Z
//asset_id	:	1000000081843935138-11-16T12:03:04.393Z
//source	:	New York Times
//published_date	:	2022-01-31
//updated	:	2022-01-31 23:52:15
//section	:	Business
//subsection	:	Media
//nytdsection	:	business
//adx_keywords	:	Wordle (Puzzle);Newspapers;Mobile Applications;News and News Media;Mergers, Acquisitions and Divestitures;Wardle, Josh;New York Times Company
//column	:	null
//byline	:	By Marc Tracy
//type	:	Article
//title	:	The New York Times Buys Wordle
//abstract	:	The word game, released in October, has millions of daily users.