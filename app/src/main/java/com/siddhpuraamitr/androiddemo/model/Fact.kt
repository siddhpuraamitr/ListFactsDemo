package com.siddhpuraamitr.androiddemo.model

import com.google.gson.annotations.Expose

class Fact(
    @Expose
    var title: String,
    @Expose
    var rows: ArrayList<Rows>
)