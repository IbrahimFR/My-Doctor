package com.Tabiby.Dao;

import com.Tabiby.Model.Favourites;

import java.util.List;

/**
 * Created by ibrahimfouad on 10/3/2016.
 */
public interface FavouriteDao {
     public void addFavourite(Favourites favourites);
     public void deleteFavourte(Favourites foFavourites);
     public List<Favourites> getFavourtes (String userName);
     public List<Favourites> getFavourites(String userName ,long clinicName );
}
