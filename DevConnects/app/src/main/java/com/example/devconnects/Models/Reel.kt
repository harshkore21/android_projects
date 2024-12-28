package com.example.devconnects.Models

class Reel {
    var reelUrl: String? = null
    var caption: String? = null
    var profileList: String? = null
    constructor()
    constructor(reelUrl: String?, caption: String?) {
        this.reelUrl = reelUrl
        this.caption = caption
    }

    constructor(reelUrl: String?, caption: String?, profileList: String) {
        this.reelUrl = reelUrl
        this.caption = caption
        this.profileList = profileList
    }
}