package com.Tabiby.service;

import com.Tabiby.Model.Favourites;

import java.util.List;

/**
 * Created by zamalek on 10/3/2016.
 */
public interface FavouriteService {
    public void addFavourite(Favourites favourites);
    public void deleteFavourte(Favourites foFavourites);
    public List<Favourites> getFavourtes (String userName);
    public List<Favourites> getFavourites(String userName ,long clinicName );
}
