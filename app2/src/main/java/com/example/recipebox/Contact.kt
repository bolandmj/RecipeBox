package com.example.recipebox

//java class database
//users information
class Contact {
    var id = 0
    var name: String? = null
    var phone_number: String? = null

    constructor() {}
    constructor(id: Int, name: String?, phone_number: String?) {
        this.id = id
        this.name = name
        this.phone_number = phone_number
    }
}