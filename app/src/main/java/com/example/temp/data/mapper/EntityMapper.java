package com.example.temp.data.mapper;

import java.util.List;

public interface EntityMapper<From, To> {

    To map(From from);

    List<To> mapMany(List<From> from);

    From mapBack(To entity);

    List<From> mapBackMany(List<To> tos);
}