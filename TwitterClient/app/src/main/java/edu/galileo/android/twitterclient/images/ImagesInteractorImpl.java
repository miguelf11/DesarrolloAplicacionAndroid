package edu.galileo.android.twitterclient.images;

/**
 * Created by Alex on 25-06-2016.
 */
public class ImagesInteractorImpl implements ImagesInteractor {
    private ImagesRepository repository;
    @Override
    public void execute() {
        repository.getImages();
    }
}
