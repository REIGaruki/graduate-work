package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdMapper {

    @Mapping(target = "count", expression = "java(ads.size())")
    @Mapping(target = "results", source = "ads")
    Ads mapToAds(List<Ad> ads);

    @Mapping(source = "ad.pk", target = "pk")
    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "ad.description", target = "description")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "ad.image", target = "image")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "ad.price", target = "price")
    @Mapping(source = "ad.title", target = "title")
    ExtendedAd mapToExtendedAd(User user, Ad ad);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    CreateOrUpdateAd mapToCreateOrUpdateAd(Ad ad);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    Ad mapFromCreateOrUpdateAd(CreateOrUpdateAd dto);

}
