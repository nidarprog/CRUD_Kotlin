package com.spring_kotlin.transformer

interface Transformer<A, B> {
    fun transform(source: A): B
}