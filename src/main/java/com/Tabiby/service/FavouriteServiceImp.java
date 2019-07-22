package com.Tabiby.service;

import com.Tabiby.Dao.FavouriteDao;
import com.Tabiby.Model.Favourites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ibrahimfouad on 10/3/2016.
 */
@Service("favouriteService")
public class FavouriteServiceImp  implements  FavouriteService{
    @Autowired
    private FavouriteDao favouriteDao;

    public FavouriteDao getFavouriteDao() {
        return favouriteDao;
    }

    public void setFavouriteDao(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    @Override
    public void addFavourite(Favourites favourites) {
        this.favouriteDao.addFavourite(favourites);
    }

    @Override
    public void deleteFavourte(Favourites foFavourites) {
   this.favouriteDao.deleteFavourte(foFavourites);
    }

    @Override
    public List<Favourites> getFavourtes(String userName) {
        return this.favouriteDao.getFavourtes(userName);
    }

    public List<Favourites> getFavourites(String userName ,long clinicName ){
        return this.favouriteDao.getFavourites(userName, clinicName);
    }
}
