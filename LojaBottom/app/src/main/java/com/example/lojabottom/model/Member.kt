package com.example.lojabottom.model

data class Member(
    val id: String,
    val name: String,
    val surname: String,
    val cc: String,
    val phone: Int,
    val locality: String,
    val notes: String,
    val warning: Boolean,
    val checkedIn: Boolean,
    val householdId: String,
    val nationalityId: String
)