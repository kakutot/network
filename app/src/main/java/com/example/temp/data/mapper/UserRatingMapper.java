package com.example.temp.data.mapper;

import com.example.tupkalenko.trainee.project.data.model.UserRatingModel;
import com.example.tupkalenko.trainee.project.domain.entity.UserRating;

import java.util.LinkedList;
import java.util.List;

public class UserRatingMapper implements EntityMapper<UserRatingModel, UserRating> {

    @Override
    public UserRating map(UserRatingModel userRatingModel) {
        UserRating.Builder builder = new UserRating.Builder();

        builder.setAggrRating(userRatingModel.getAggrRating())
                .setRatingColor(userRatingModel.getRatingColor())
                .setRatingText(userRatingModel.getRatingText())
                .setVotes(userRatingModel.getVotes());

        return builder.build();
    }

    @Override
    public List<UserRating> mapMany(List<UserRatingModel> userRatingModels) {
        List<UserRating> userRatings = new LinkedList<>();

        for(UserRatingModel userRatingModel : userRatingModels) {
            userRatings.add(map(userRatingModel));
        }

        return userRatings;
    }

    @Override
    public UserRatingModel mapBack(UserRating userRating) {
        UserRatingModel.Builder builder = new UserRatingModel.Builder();

        builder.setAggrRating(userRating.getAggrRating())
                .setRatingColor(userRating.getRatingColor())
                .setRatingText(userRating.getRatingText())
                .setVotes(userRating.getVotes());

        return builder.build();
    }

    @Override
    public List<UserRatingModel> mapBackMany(List<UserRating> userRatings) {
        List<UserRatingModel> userRatingModels = new LinkedList<>();

        for(UserRating userRating : userRatings) {
            userRatingModels.add(mapBack(userRating));
        }

        return userRatingModels;
    }
}
